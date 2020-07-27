package com.carbon.analyser.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DayDto {
    @JacksonXmlProperty(localName = "ReadingT1")
    private Double readingT1;
    @JacksonXmlProperty(localName = "ReadingT2")
    private Double readingT2;
    @JacksonXmlProperty(localName = "ReadingT3")
    private Double readingT3;
    @JacksonXmlProperty(localName = "ReadingT4")
    private Double readingT4;
    @JacksonXmlProperty(localName = "ReadingAvg")
    private Double readingAvg;
    @JacksonXmlProperty(localName = "ReadingMin")
    private Double readingMin;
    @JacksonXmlProperty(localName = "ReadingMax")
    private Double readingMax;
    @JacksonXmlProperty(localName = "Date")
    private String date;

    public Double getReadingT1() {
        return readingT1;
    }

    public void setReadingT1(Double readingT1) {
        this.readingT1 = readingT1;
    }

    public Double getReadingT2() {
        return readingT2;
    }

    public void setReadingT2(Double readingT2) {
        this.readingT2 = readingT2;
    }

    public Double getReadingT3() {
        return readingT3;
    }

    public void setReadingT3(Double readingT3) {
        this.readingT3 = readingT3;
    }

    public Double getReadingT4() {
        return readingT4;
    }

    public void setReadingT4(Double readingT4) {
        this.readingT4 = readingT4;
    }

    public Double getReadingAvg() {
        return readingAvg;
    }

    public void setReadingAvg(Double readingAvg) {
        this.readingAvg = readingAvg;
    }

    public Double getReadingMin() {
        return readingMin;
    }

    public void setReadingMin(Double readingMin) {
        this.readingMin = readingMin;
    }

    public Double getReadingMax() {
        return readingMax;
    }

    public void setReadingMax(Double readingMax) {
        this.readingMax = readingMax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
