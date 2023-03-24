package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LegsItem{

	@JsonProperty("Type")
	private String type;

	@JsonProperty("FlightID")
	private String flightID;
}