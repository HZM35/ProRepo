package com.example.sprint2.Controllers;

import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Services.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class SensorDataController {
    private final long minusOneWeek = 1;
    private final long minusOneHour = 1;

    @Autowired
    private SensorDataService sensorDataservice;


    public SensorDataController(SensorDataService sensorDataservice) {
        super();
        this.sensorDataservice = sensorDataservice;

    }


    @GetMapping("/lastUpdate")
    public List<SensorData> getAllLastUpdate() {
        return sensorDataservice.getAllLastUpdate();
    }

    @RequestMapping("/lastHourData")
    public List<SensorData> getDataLastHour(@RequestParam("deviceId") String deviceId) {

        LocalDateTime lastHourTime = LocalDateTime.now().minusHours(minusOneHour);// vor einer Stunde

        return sensorDataservice.getDataLastHour(deviceId, lastHourTime);// hier bekommt man die Nachrichten  ab @lastHourTime
    }

    @RequestMapping("/lastWeekData")
    public List<SensorData> getDataLastWeek(@RequestParam("deviceId") String deviceId) {

        LocalDate lastWeek = LocalDate.now();// vor einer Stunde 22.11.2022
        LocalDateTime  lastWeekTime = lastWeek.atStartOfDay().minusWeeks(minusOneWeek); //

        return sensorDataservice.getDataLastWeek(deviceId, lastWeekTime);// hier bekommt man die Nachrichten  ab @lastHourTime
    }

    @RequestMapping("/datePicker")
    public List<SensorData> getSensorDataBetweenTwoDates(@RequestParam("deviceId") String deviceId, @RequestParam("fromRecievedAt") String fromRecievedAt, @RequestParam("toRecievedAt") String toRecievedAt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");



        LocalDate from1 = LocalDate.parse(fromRecievedAt,formatter);
        LocalDate to1 = LocalDate.parse(toRecievedAt,formatter);
        LocalDateTime from = from1.atStartOfDay();
        LocalDateTime to = to1.atTime(23,59,59,99999);

        return sensorDataservice.getSensorDataBetweenTwoDates(deviceId, from, to);
    }

    @RequestMapping("/findSensorById")
    public List<SensorData> getsensorIdWithLastUpdate(@RequestParam("deviceId") String deviceId) {
        return sensorDataservice.getsensorIdWithLastUpdate(deviceId);

    }


}
