package com.batuhanozudogru.assignment3.controller;

import com.batuhanozudogru.assignment3.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("weather")
public class WeatherController {


    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> weatherForecastAverage(@RequestParam(required = true) String city) {
        return weatherService.weatherForecastAverage(city);
    }
}
