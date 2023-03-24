package com.example.demo.mapper;

import com.example.demo.domain.Duties;
import com.example.demo.domain.Legs;
import com.example.demo.domain.Pairing;
import com.example.demo.dto.DutiesItem;
import com.example.demo.dto.LegsItem;
import com.example.demo.dto.PairingsItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T07:21:51+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class PairingMapperImpl implements PairingMapper {

    @Override
    public List<Pairing> mapToPairing(List<PairingsItem> pairingsItems) {
        if ( pairingsItems == null ) {
            return null;
        }

        List<Pairing> list = new ArrayList<Pairing>( pairingsItems.size() );
        for ( PairingsItem pairingsItem : pairingsItems ) {
            list.add( map( pairingsItem ) );
        }

        return list;
    }

    @Override
    public Pairing map(PairingsItem dto) {
        if ( dto == null ) {
            return null;
        }

        Pairing pairing = new Pairing();

        pairing.setFleet( dto.getFleet() );
        pairing.setDateTimeStart( dto.getDateTimeStart() );
        pairing.setDateTimeEnd( dto.getDateTimeEnd() );
        pairing.setPairingID( dto.getPairingId() );
        pairing.setDuties( dutiesItemListToDutiesList( dto.getDuties() ) );

        return pairing;
    }

    @Override
    public Duties dutiesMap(DutiesItem dto) {
        if ( dto == null ) {
            return null;
        }

        Duties duties = new Duties();

        duties.setDateTimeEnd( dto.getDateTimeEnd() );
        duties.setDateTimeStart( dto.getDateTimeStart() );
        duties.setLegs( legsItemListToLegsList( dto.getLegs() ) );

        return duties;
    }

    @Override
    public Legs legsMap(LegsItem dto) {
        if ( dto == null ) {
            return null;
        }

        Legs legs = new Legs();

        legs.setType( dto.getType() );
        legs.setFlightID( dto.getFlightID() );

        return legs;
    }

    protected List<Duties> dutiesItemListToDutiesList(List<DutiesItem> list) {
        if ( list == null ) {
            return null;
        }

        List<Duties> list1 = new ArrayList<Duties>( list.size() );
        for ( DutiesItem dutiesItem : list ) {
            list1.add( dutiesMap( dutiesItem ) );
        }

        return list1;
    }

    protected List<Legs> legsItemListToLegsList(List<LegsItem> list) {
        if ( list == null ) {
            return null;
        }

        List<Legs> list1 = new ArrayList<Legs>( list.size() );
        for ( LegsItem legsItem : list ) {
            list1.add( legsMap( legsItem ) );
        }

        return list1;
    }
}
