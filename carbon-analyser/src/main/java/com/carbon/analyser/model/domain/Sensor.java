package com.carbon.analyser.model.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sensor_detail")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;

    @Column(name = "sensor_loc")
    private String sensorLoc;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor")
    private Set<Reading> readings;

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

    public Set<Reading> getReadings() {
        return readings;
    }

    public void setReadings(Set<Reading> readings) {
        this.readings = readings;
    }
}
