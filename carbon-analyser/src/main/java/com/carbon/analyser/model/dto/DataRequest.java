package com.carbon.analyser.model.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class DataRequest {
    private Long cityId;
    private String reportType;
    private String startDate;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
