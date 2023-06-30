package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
