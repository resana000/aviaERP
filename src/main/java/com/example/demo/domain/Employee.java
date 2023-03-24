package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String externalId;

    private String gender;

    private String fleet;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    List<PairingAssigment> pairings = new ArrayList<>();

    //    @ManyToMany(targetEntity = Flight.class, fetch = FetchType.LAZY, cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE})
//    @JoinTable(
//            name = "Employee_Flight",
//            joinColumns = { @JoinColumn(name = "external_id") },
//            inverseJoinColumns = { @JoinColumn(name = "flight_id")})
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<EmployeeFlight> flights = new ArrayList<>();

    public void addFlights(List<Flight> flightsList) {
        flightsList.stream().forEach(a-> {
            EmployeeFlight employeeFlight = new EmployeeFlight(this, a);
            this.flights.add(employeeFlight);
        });
    }

    public void addPairing(Pairing pairing, String rank) {
        PairingAssigment pairingAssigment = new PairingAssigment(this, pairing, rank);
        pairings.add(pairingAssigment);
    }

    public void removePairing(Pairing pairing) {
        for (Iterator<PairingAssigment> iterator = pairings.iterator();
             iterator.hasNext(); ) {
            PairingAssigment pairingAssigment = iterator.next();

            if (pairingAssigment.getPairing().equals(this) &&
                    pairingAssigment.getEmployee().equals(pairing)) {
                iterator.remove();
                pairingAssigment.setPairing(null);
                pairingAssigment.setEmployee(null);
            }
        }
    }


    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
