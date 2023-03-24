package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FlightsItem{

	@JsonProperty("FlightNum")
	private String flightNum;

	@JsonProperty("Fleet")
	private String fleet;

	@JsonProperty("TerminalArrival")
	private String terminalArrival;

	@JsonProperty("StationDeparture")
	private String stationDeparture;

	@JsonProperty("CountryDeparture")
	private String countryDeparture;

	@JsonProperty("CountryArrival")
	private String countryArrival;

	@JsonProperty("ServiceType")
	private String serviceType;

	@JsonProperty("ID")
	private String id;

	@JsonProperty("Carrier")
	private String carrier;

	@JsonProperty("DateTimeArrival")
	private String dateTimeArrival;

	@JsonProperty("AircraftType")
	private String aircraftType;

	@JsonProperty("StationArrival")
	private String stationArrival;

	@JsonProperty("DateTimeDeparture")
	private String dateTimeDeparture;

	@JsonProperty("Cancelled")
	private boolean cancelled;

	@JsonProperty("KatMeteoMin")
	private String katMeteoMin;

	@JsonProperty("TerminalDeparture")
	private String terminalDeparture;

	@JsonProperty("IndexPort")
	private String indexPort;

	@JsonProperty("TimeDepartureShift")
	private String timeDepartureShift;

	@JsonProperty("TimeArrivalShift")
	private String timeArrivalShift;
}