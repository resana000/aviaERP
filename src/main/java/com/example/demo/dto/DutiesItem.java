package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DutiesItem{

	@JsonProperty("Legs")
	private List<LegsItem> legs;

	@JsonProperty("DateTimeEnd")
	private String dateTimeEnd;

	@JsonProperty("DateTimeStart")
	private String dateTimeStart;
}