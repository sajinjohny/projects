package com.carbon.analyser.service;

import com.carbon.analyser.model.domain.Reading;
import com.carbon.analyser.model.dto.CityDto;
import com.carbon.analyser.model.dto.ReadingDto;
import com.carbon.analyser.repository.ReadingRespository;
import com.carbon.analyser.tranformer.ReadingRequestTransFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadingService {

    @Autowired
    ReadingRespository readingRespository;

    @Autowired
    ReadingRequestTransFormer readingRequestTransFormer;

    public boolean addReading(ReadingDto readingDto)
    {
        Reading reading=readingRequestTransFormer.transForm(readingDto);
        if(reading.getSensor()!=null)
        {
            readingRespository.save(reading);
            return true;
        }
        return false;
    }

}
