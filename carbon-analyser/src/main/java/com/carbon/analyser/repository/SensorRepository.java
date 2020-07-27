package com.carbon.analyser.repository;

import com.carbon.analyser.model.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor,Long> {

}
