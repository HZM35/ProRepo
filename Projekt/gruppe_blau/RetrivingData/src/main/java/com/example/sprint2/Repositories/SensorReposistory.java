package com.example.sprint2.Repositories;

import com.example.sprint2.Entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorReposistory extends JpaRepository<Sensor, Long> {
//    lists all available sensor_ids
    @Query("select s.deviceId from Sensor s")
    List<String> getAllId();

}
