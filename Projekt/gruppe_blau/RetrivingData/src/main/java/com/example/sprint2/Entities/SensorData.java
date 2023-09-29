package com.example.sprint2.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "sensor_data")
@IdClass(SensorDataID.class)
public class SensorData implements Serializable {

    private Double temperature;
    private Integer humidity;


    @Id
    private LocalDateTime recievedAt;

    @Id
    @ManyToOne
    private Sensor sensor;





    public SensorData(Double temperature, Integer humidity, LocalDateTime recievedAt) {
        super();
        this.temperature = temperature;
        this.humidity = humidity;
        this.recievedAt = recievedAt;
    }



    public void setRecievedAt(String recievedAt) {

        if(!recievedAt.equals(null)){
            // convert the String to LocalDateTime and get the result in local TimeZone
            LocalDateTime dateTimeWithOffset = Instant.parse(recievedAt).atZone(ZoneId.systemDefault()).toLocalDateTime();

            this.recievedAt = dateTimeWithOffset;
        }
    }

}