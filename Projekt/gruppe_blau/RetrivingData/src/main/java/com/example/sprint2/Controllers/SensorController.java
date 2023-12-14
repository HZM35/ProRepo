package com.example.sprint2.Controllers;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SensorController {

    @Autowired
    private SensorService sensorService;

    SensorController(SensorService sensorService) {
        this.sensorService = sensorService;

    }

    @GetMapping("/allSensors")
    public List<String> getAllId() {

        return sensorService.getAllId();
    }

}
