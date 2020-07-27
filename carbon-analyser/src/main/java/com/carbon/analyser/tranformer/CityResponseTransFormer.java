package com.carbon.analyser.tranformer;

import com.carbon.analyser.model.domain.City;
import com.carbon.analyser.model.domain.District;
import com.carbon.analyser.model.domain.Reading;
import com.carbon.analyser.model.domain.Sensor;
import com.carbon.analyser.model.domain.interfaces.AnalyticalValues;
import com.carbon.analyser.model.dto.*;
import com.carbon.analyser.repository.ReadingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CityResponseTransFormer {

    @Autowired
    private ReadingRespository readingRespository;

    public  CityDto transForm(City city, DataRequest request)
    {
    CityDto cityDto =new CityDto();
    cityDto.setId(city.getId());
    cityDto.setCityName(city.getCityName());
    transFormDistrict(cityDto,city,request);
    return cityDto;
    }
    private  void transFormDistrict(CityDto cityDto,City city,DataRequest request)
    {
        cityDto.setDistrict(city.getDistricts().stream().map(dis->{
         DistrictDto districtDto=new DistrictDto();
           districtDto.setDistrictName(dis.getDistrictName());
           transFromSensor(districtDto,dis,request);
           return districtDto;
       }).collect(Collectors.toSet()));



    }
    private  void transFromSensor(DistrictDto districtDto,District district,DataRequest request)
    {
        districtDto.setSensor(district.getSensors().stream().map(sensor->{
            SensorDto sensorDto=new SensorDto();
            sensorDto.setSensorLoc(sensor.getSensorLoc());
            //sensorDto.setId(sensor.getId());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(request.getStartDate(), formatter);

            ZonedDateTime startDateTime = date.atStartOfDay(ZoneId.systemDefault());

            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumIntegerDigits(2);
            switch (request.getReportType())
            {
                case "daily":
                    List<DayDto> days=new ArrayList<>();
                    days.add(getDailyReading(sensorDto,startDateTime,sensor,df));
                   sensorDto.setDay(days);
                    //findMinMaxAvgDay(sensorDto,request.getStartDate(),sensor);
                    break;
                case "weekly":
                    List<DayDto> daysOfWeek=new ArrayList<>();
                  for(int i=1;i<=7;++i) {
                      daysOfWeek.add(getDailyReading(sensorDto, startDateTime, sensor,df));
                      startDateTime=startDateTime.plusDays(1);
                  }
                    sensorDto.setDay(daysOfWeek);

                    break;
                case "monthly":

                    break;
                default:
                    sensorDto.setDay(null);
            }
            return sensorDto;
        }).collect(Collectors.toSet()));

    }

    private DayDto getDailyReading(SensorDto sensorDto, ZonedDateTime startDateTime, Sensor sensor,DecimalFormat df){

        List<ZonedDateTime> dates=new ArrayList<>();

        dates.add(startDateTime.with(ChronoField.HOUR_OF_DAY,5));
        dates.add(startDateTime.with(ChronoField.HOUR_OF_DAY,11));
        dates.add(startDateTime.with(ChronoField.HOUR_OF_DAY,17));
        dates.add(startDateTime.with(ChronoField.HOUR_OF_DAY,23));

       List<Reading> readings=readingRespository.readingByDate(dates,sensor);
       DayDto day=new DayDto();
       if(!readings.isEmpty()) {
           day.setReadingT1(Optional.ofNullable(readings.get(0).getReading()).orElse(null));
           day.setReadingT2(Optional.ofNullable(readings.get(0).getReading()).orElse(null));
           day.setReadingT3(Optional.ofNullable(readings.get(0).getReading()).orElse(null));
           day.setReadingT4(Optional.ofNullable(readings.get(0).getReading()).orElse(null));
       }
       java.util.Date dateLimit=Date.from(startDateTime.toInstant());
       AnalyticalValues analyticalValues=readingRespository.findMinMaxAvg(sensor.getId(), Date.from(startDateTime.toInstant()));
       day.setReadingMin(analyticalValues.getMin());
       day.setReadingMax(analyticalValues.getMax());
       if(analyticalValues.getAvg()!=null) {
           day.setReadingAvg(Double.parseDouble(df.format(analyticalValues.getAvg())));
       }
       String pattern = "dd MMMMM,yyyy";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
       day.setDate(simpleDateFormat.format(dateLimit));
       return day;
    }

}
