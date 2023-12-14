package com.example.sprint2.Services;


import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Repositories.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {
    @Autowired
    private SensorDataRepository senorDataRepsitory;


    public SensorDataService(SensorDataRepository senorDataRepsitory) {
        super();
        this.senorDataRepsitory = senorDataRepsitory;
    }


    public List<SensorData> getAllLastUpdate() {
        return senorDataRepsitory.getLastUpdate();
    }

    public List<SensorData> getsensorIdWithLastUpdate(String deviceId) {
        return senorDataRepsitory.getsensorIdWithLastUpdate(deviceId);
    }

    public List<SensorData> getDataLastHour(String deviceId , LocalDateTime lastHourTime) {

        return senorDataRepsitory.getDataLastHour(deviceId,  lastHourTime );
    }
    public List<SensorData> getDataLastWeek(String deviceId , LocalDateTime lastWeekTime) {

        return senorDataRepsitory.getDataLastWeek(deviceId,  lastWeekTime );
    }
    public List<SensorData> getSensorDataBetweenTwoDates(String deviceID, LocalDateTime fromRecievedAt, LocalDateTime toRecievedAt) {

        return senorDataRepsitory.getSensorDataBetweenTwoDates(deviceID, fromRecievedAt, toRecievedAt);
    }

}
