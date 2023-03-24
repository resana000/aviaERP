package com.example.demo.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pairing")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pairingid")
    private Long pairingID;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    private String fleet;

    // TODO:  define format ZonedDateTime ?
    private String dateTimeStart;

    // TODO:  define format ZonedDateTime ?
    private String dateTimeEnd;

    @OneToMany(mappedBy = "pairing", cascade = CascadeType.ALL)
    List<Duties> duties = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pairing pairing = (Pairing) o;
        return id != null && Objects.equals(id, pairing.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
