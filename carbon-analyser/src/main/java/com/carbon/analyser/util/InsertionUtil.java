package com.carbon.analyser.util;

import com.carbon.analyser.model.domain.Reading;
import com.carbon.analyser.model.domain.Sensor;
import com.carbon.analyser.repository.ReadingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InsertionUtil {

    @Autowired
    private ReadingRespository readingRespository;

    public void insert(String dateString)
    {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumIntegerDigits(2);
        long sensorId=1;
        while(sensorId<=18l) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, formatter);

            ZonedDateTime startDateTime = date.atStartOfDay(ZoneId.systemDefault());
            ZonedDateTime dateTimest=startDateTime.with(ChronoField.HOUR_OF_DAY,23);

            int hour = 0;
            int min = 0;
            Double minRange=415.03;
            Double maxRange=420.03;
            List<Reading> reading = new ArrayList<>();
            Sensor sensor = new Sensor();
            sensor.setId(sensorId++);
            while (hour < 24) {
                while (min < 60) {
                    Reading readingData = new Reading();
                    readingData.setDateTime(startDateTime.with(ChronoField.HOUR_OF_DAY,hour).with(ChronoField.MINUTE_OF_HOUR,min));
                    Random r = new Random();
                    double randomValue = minRange + (maxRange - minRange) * r.nextDouble();
                    readingData.setReading(Double.parseDouble(df.format(randomValue)));
                    readingData.setSensor(sensor);
                    reading.add(readingData);

                    min = min + 5;

                }
                min = 0;
                hour = hour + 1;
            }
            readingRespository.saveAll(reading);
        }
    }
}
