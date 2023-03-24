package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirPortQualItem{

	@JsonProperty("Port")
	private String port;

	@JsonProperty("EndDate")
	private String endDate;

	@JsonProperty("Kat")
	private String kat;
}