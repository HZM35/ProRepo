package com.example.sprint2.Services;


import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Repositories.SensorReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    public final SensorReposistory sensorReposistory;

    public SensorService(SensorReposistory sensorReposistory) {
        this.sensorReposistory = sensorReposistory;
    }

    public void saveSensor(Sensor sensor){
        sensorReposistory.save(sensor);

    }

    public List<String> getAllId(){
     return sensorReposistory.getAllId();   // sensorReposistory.findAll();
    }
}
