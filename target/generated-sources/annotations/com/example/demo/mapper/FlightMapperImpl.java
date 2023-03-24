package com.example.demo.mapper;

import com.example.demo.domain.Flight;
import com.example.demo.dto.FlightsItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T07:23:53+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public List<Flight> mapToFlight(List<FlightsItem> flightDtos) {
        if ( flightDtos == null ) {
            return null;
        }

        List<Flight> list = new ArrayList<Flight>( flightDtos.size() );
        for ( FlightsItem flightsItem : flightDtos ) {
            list.add( map( flightsItem ) );
        }

        return list;
    }

    @Override
    public Flight map(FlightsItem dto) {
        if ( dto == null ) {
            return null;
        }

        Flight flight = new Flight();

        flight.setExternalId( dto.getId() );
        flight.setFlightNum( dto.getFlightNum() );
        flight.setStationDeparture( dto.getStationDeparture() );
        flight.setStationArrival( dto.getStationArrival() );
        flight.setDateTimeDeparture( dto.getDateTimeDeparture() );
        flight.setDateTimeArrival( dto.getDateTimeArrival() );
        if ( dto.getId() != null ) {
            flight.setId( Long.parseLong( dto.getId() ) );
        }

        return flight;
    }
}
