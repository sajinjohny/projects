package com.carbon.analyser.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Report")
public class ReportDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "City")
    private List<CityDto> city;

    public List<CityDto> getCity() {
        return city;
    }

    public void setCity(List<CityDto> city) {
        this.city = city;
    }
}
