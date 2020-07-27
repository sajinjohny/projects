package com.carbon.analyser.repository;

import com.carbon.analyser.model.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository <City,Long> {

}
