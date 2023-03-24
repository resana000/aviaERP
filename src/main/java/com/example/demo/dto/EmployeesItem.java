package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesItem{

	@JsonProperty("Fleet")
	private String fleet;

	@JsonProperty("Skills")
	private List<String> skills;

	@JsonProperty("FleetsPers")
	private List<FleetsPersItem> fleetsPers;

	@JsonProperty("AirPortQual")
	private List<AirPortQualItem> airPortQual;

	@JsonProperty("Citizenship")
	private String citizenship;

	@JsonProperty("ID")
	private String employeeId;

	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("MaxFlightHours")
	private String maxFlightHours;

	@JsonProperty("Qualifications")
	private List<QualificationsItem> qualifications;
}