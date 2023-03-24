package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AssignmentsItem{

	@JsonProperty("Station")
	private String station;

	@JsonProperty("DateTimeEnd")
	private String dateTimeEnd;

	@JsonProperty("WorkCredit")
	private int workCredit;

	@JsonProperty("DateTimeStart")
	private String dateTimeStart;

	@JsonProperty("Activity")
	private String activity;

	@JsonProperty("Rank")
	private String rank;

	@JsonProperty("Actual")
	private int actual;

	@JsonProperty("EmployeeID")
	private String employeeID;

	@JsonProperty("PairingIBMID")
	private String pairingIBMID;

	@JsonProperty("PairingID")
	private Long pairingID;
}