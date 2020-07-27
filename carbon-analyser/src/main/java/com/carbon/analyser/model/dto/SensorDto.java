package com.carbon.analyser.model.dto;
import com.carbon.analyser.model.domain.Reading;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SensorDto {

    private Long id;
    @JacksonXmlProperty(localName = "Location")
    private String sensorLoc;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Day")
    private List<DayDto> day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorLoc() {
        return sensorLoc;
    }

    public void setSensorLoc(String sensorLoc) {
        this.sensorLoc = sensorLoc;
    }

    public List<DayDto> getDay() {
        return day;
    }

    public void setDay(List<DayDto> day) {
        this.day = day;
    }
}
