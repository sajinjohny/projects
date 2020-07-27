package com.carbon.analyser.tranformer;

import com.carbon.analyser.model.domain.Reading;
import com.carbon.analyser.model.domain.Sensor;
import com.carbon.analyser.model.dto.ReadingDto;
import com.carbon.analyser.repository.ReadingRespository;
import com.carbon.analyser.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ReadingRequestTransFormer {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ReadingRespository readingRespository;

    public Reading transForm(ReadingDto readingDto)
    {
        Reading reading=new Reading();
        reading.setReading(readingDto.getReading());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.parse(readingDto.getDateTime(), formatter);
        ZonedDateTime startDateTime = date.atStartOfDay(ZoneId.systemDefault());
        reading.setDateTime(startDateTime);
        Optional<Sensor> sensor=sensorRepository.findById(readingDto.getSensorId());
        if (sensor.isPresent()) {
            reading.setSensor(sensor.get());
        } else {
            reading.setSensor(null);
        }
        return reading;
    }

}
