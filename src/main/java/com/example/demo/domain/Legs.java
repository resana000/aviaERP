package com.example.demo.domain;

import com.example.demo.dto.LegsItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "legs")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Legs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    private String type;

    private String flightID;

    @ManyToOne
    @JoinColumn(name = "duties_id")
    Duties duties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Legs pairing = (Legs) o;
        return id != null && Objects.equals(id, pairing.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
