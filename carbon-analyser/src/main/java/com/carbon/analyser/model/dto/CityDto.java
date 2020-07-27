package com.carbon.analyser.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CityDto{

    private Long id;

    @JacksonXmlProperty(localName = "Name")
    private String cityName;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "District")
    private Set<DistrictDto> district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<DistrictDto> getDistrict() {
        return district;
    }

    public void setDistrict(Set<DistrictDto> district) {
        this.district = district;
    }
}