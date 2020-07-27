package com.carbon.analyser.repository;

import com.carbon.analyser.model.domain.Reading;
import com.carbon.analyser.model.domain.Sensor;
import com.carbon.analyser.model.domain.interfaces.AnalyticalValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface ReadingRespository extends JpaRepository<Reading,Long> {

    @Query("select reading from Reading reading where reading.dateTime in :dates and reading.sensor = :sensor order by reading.dateTime")
    public List<Reading> readingByDate(@Param("dates") List<ZonedDateTime> dates, @Param("sensor")Sensor sensor);

    @Query(value = "select min(reading) as min,max(reading) as max,avg(reading) as avg from sensor_readings where sensor = :sensorId and  cast(time as date) = :date",nativeQuery = true)
    public AnalyticalValues findMinMaxAvg(Long sensorId, Date date);
}
