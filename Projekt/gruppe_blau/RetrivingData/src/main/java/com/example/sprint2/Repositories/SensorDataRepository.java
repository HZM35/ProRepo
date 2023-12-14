package com.example.sprint2.Repositories;

import com.example.sprint2.Entities.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {


    @Query("  SELECT sd FROM SensorData sd WHERE sd.recievedAt in (Select  max(sd.recievedAt) from SensorData sd  Group by  sd.sensor.deviceId) order by sd.recievedAt desc ")
    List<SensorData> getLastUpdate();

    @Query(nativeQuery = true, value = "SELECT * FROM sensor_data where sensor_device_ID =:deviceId ORDER BY recieved_at desc LIMIT 1  ")
    List<SensorData> getsensorIdWithLastUpdate(@Param("deviceId") String deviceId);

    @Query(nativeQuery = true, value = "SELECT  * FROM  sensor_data  where sensor_device_id =:deviceId  and recieved_at >= :lastHourTime  order by recieved_at desc ")
    List<SensorData> getDataLastHour(@Param("deviceId") String deviceId, LocalDateTime lastHourTime);
    @Query( "SELECT  sd FROM  SensorData sd  where sd.sensor.deviceId =:deviceId  and sd.recievedAt >= :lastWeekTime  order by sd.recievedAt desc ")
    List<SensorData> getDataLastWeek(@Param("deviceId") String deviceId, LocalDateTime lastWeekTime);

    @Query("SELECT sd FROM SensorData sd " +
            "WHERE sd.sensor.deviceId =:deviceID  AND  sd.recievedAt" +
            " BETWEEN  :fromRecievedAt AND :toRecievedAt  order by sd.recievedAt desc")
    List<SensorData> getSensorDataBetweenTwoDates
            (@Param("deviceID") String deviceID, @Param("fromRecievedAt") LocalDateTime fromRecievedAt, @Param("toRecievedAt") LocalDateTime toRecievedAt);


}
