package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class FlightsDto{

	@JsonProperty("Flights")
	private List<FlightsItem> flights;

	@JsonProperty("Version")
	private int version;

	@JsonProperty("Division")
	private String division;

	@JsonProperty("Caption")
	private String caption;

	@JsonProperty("Created")
	private String created;
}