package com.example.demo.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PairingsItem{

	@JsonProperty("TypePairing")
	private String typePairing;

	@JsonProperty("Crew")
	private List<CrewItem> crew;

	@JsonProperty("DateTimeEnd")
	private String dateTimeEnd;

	@JsonProperty("Fleet")
	private String fleet;

	@JsonProperty("Duties")
	private List<DutiesItem> duties;

	@JsonProperty("RestEnd")
	private String restEnd;

	@JsonProperty("DateTimeStart")
	private String dateTimeStart;

	@JsonProperty("FlightCredit")
	private int flightCredit;

	@JsonProperty("ID")
	private Long pairingId;

	@JsonProperty("WorkCreditInMonth")
	private int workCreditInMonth;

	@JsonProperty("FlightCreditInMonth")
	private int flightCreditInMonth;

	@JsonProperty("IBMID")
	private String iBMID;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PairingsItem that = (PairingsItem) o;
		return Objects.equals(pairingId, that.pairingId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pairingId);
	}

	@JsonProperty("Station")
	private String station;
}