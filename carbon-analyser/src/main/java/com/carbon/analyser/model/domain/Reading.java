package com.carbon.analyser.model.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "sensor_readings")
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Long id;

    @Column(name = "reading")
    private Double reading;

    @Column(name = "time")
    private ZonedDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "sensor",referencedColumnName = "sensor_id")
    private Sensor sensor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
