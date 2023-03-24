package com.example.demo.domain;

import com.example.demo.dto.LegsItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "duties")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Duties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @ManyToOne
    @JoinColumn(name = "pairing_id")
    Pairing pairing;

    @OneToMany(mappedBy = "duties", cascade = CascadeType.ALL)
    List<Legs> legs = new ArrayList<>();

    private String dateTimeEnd;

    private String dateTimeStart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Duties pairing = (Duties) o;
        return id != null && Objects.equals(id, pairing.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
