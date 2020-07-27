package com.carbon.analyser.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DistrictDto {

    private Long id;
    @JacksonXmlProperty(localName = "Name")
    private String districtName;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Sensor")
    private Set<SensorDto> sensor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Set<SensorDto> getSensor() {
        return sensor;
    }

    public void setSensor(Set<SensorDto> sensor) {
        this.sensor = sensor;
    }
}
