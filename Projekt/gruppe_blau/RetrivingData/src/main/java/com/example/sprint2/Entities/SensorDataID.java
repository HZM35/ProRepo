package com.example.sprint2.Entities;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
@Component
public class SensorDataID implements Serializable{
	
	
	private LocalDateTime recievedAt;
	 private String sensor;
	public SensorDataID() {
		super();
	}
	 
	 
	 
}
