package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FleetsPersItem{

	@JsonProperty("Fleet")
	private String fleet;

	@JsonProperty("FleetSkills")
	private List<String> fleetSkills;

	@JsonProperty("Rank")
	private String rank;

	@JsonProperty("IndexPort")
	private String indexPort;
}