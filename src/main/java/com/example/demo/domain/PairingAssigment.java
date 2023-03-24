package com.example.demo.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pairing_assigment")
@Getter
@Setter
@NoArgsConstructor
public class PairingAssigment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public PairingAssigment(Employee employee, Pairing pairing, String rank) {
        this.employee = employee;
        this.pairing = pairing;
        this.rank = rank;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pairingid")
    private Pairing pairing;

    @Column(length = 10)
    private String rank;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PairingAssigment that = (PairingAssigment) o;
        return id != 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

