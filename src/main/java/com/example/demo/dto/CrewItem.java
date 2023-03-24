package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CrewItem{

	@JsonProperty("CPT")
	private int cPT;

	@JsonProperty("FO")
	private int fO;
}