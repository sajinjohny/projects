package com.carbon.analyser.provider;


import com.carbon.analyser.model.domain.Sensor;
import com.carbon.analyser.model.dto.CityDto;
import com.carbon.analyser.model.dto.DataRequest;
import com.carbon.analyser.model.dto.ReadingDto;
import com.carbon.analyser.model.dto.ReportDto;
import com.carbon.analyser.service.CityService;
import com.carbon.analyser.service.ReadingService;
import com.carbon.analyser.util.InsertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping("/city")
public class CityRestProvider {

    @Autowired
    private CityService cityService;

    @Autowired
    private ReadingService readingService;

    @Autowired
    private InsertionUtil insertionUtil;

    @GetMapping
    public Set<CityDto> getCityDetails()
    {
        return cityService.getCityDetails();
    }


    @GetMapping("/insert/{date}")
    public void insert(@PathVariable(value = "date",required = true)String date){
        insertionUtil.insert(date);
    }


    @PostMapping(value = "/sensor/reading",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,String> addReading(@RequestBody ReadingDto readingDto)
    {
        Map<String,String> result=new HashMap<>();
      if(readingService.addReading(readingDto))
      {
          result.put("message","Reading Added Successfully");
      }
      else {
          result.put("message", "Sensor Not Found");
      }
      return result;
    }


    @PostMapping(value = "/report",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ReportDto acceptCity(@RequestBody DataRequest request)
    {
        ReportDto report= new ReportDto();
        report.setCity(Arrays.asList(cityService.findReadingsOfCity(request)));
        return report;
    }
}
