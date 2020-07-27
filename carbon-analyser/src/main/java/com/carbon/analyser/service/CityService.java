package com.carbon.analyser.service;

import com.carbon.analyser.model.dto.DataRequest;
import com.carbon.analyser.repository.ReadingRespository;
import com.carbon.analyser.tranformer.CityResponseTransFormer;
import com.carbon.analyser.model.dto.CityDto;
import com.carbon.analyser.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ReadingRespository readingRespository;

    @Autowired
    private CityResponseTransFormer cityResponseTransFormer;


    public Set<CityDto> getCityDetails(){
        return cityRepository.findAll().stream().map(city->{
               CityDto cityDto=new CityDto();
               cityDto.setId(city.getId());
               cityDto.setCityName(city.getCityName());
               return cityDto;
        }).collect(Collectors.toSet());

    }

    public CityDto findReadingsOfCity(DataRequest request)
    {
        return cityResponseTransFormer.transForm(cityRepository.findById(request.getCityId()).get(),request);
    }

}
