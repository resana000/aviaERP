package com.example.demo.repository;

import com.example.demo.domain.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {

    Optional<Pairing> findById(Long id);
}
