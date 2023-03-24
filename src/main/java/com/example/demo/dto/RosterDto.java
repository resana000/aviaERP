package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class RosterDto {

	@JsonProperty("StartDate")
	private String startDate;

	@JsonProperty("Fleets")
	private String fleets;

	@JsonProperty("Crew")
	private String crew;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Pairings")
	private List<PairingsItem> pairings;

	@JsonProperty("Version")
	private String version;

	@JsonProperty("Assignments")
	private List<AssignmentsItem> assignments;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Class")
	private String clas;

	@JsonProperty("EndDate")
	private String endDate;

	@JsonProperty("Caption")
	private String caption;

	@JsonProperty("Created")
	private String created;
}