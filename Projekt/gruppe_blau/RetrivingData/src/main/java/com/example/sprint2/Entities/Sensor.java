package com.example.sprint2.Entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "sensor")
@Data
public class Sensor implements Serializable {
    @Id
    @Column(name = "device_ID", nullable = false)
    private String deviceId;
    private Double lattitiude;
    private Double longitude;

    public Sensor(String deviceId) {
        super();
        this.deviceId = deviceId;
    }

}