package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QualificationsItem{

	@JsonProperty("StartDate")
	private String startDate;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("EndDate")
	private String endDate;

	@JsonProperty("Prim")
	private String prim;

	@JsonProperty("SabType")
	private String sabType;
}