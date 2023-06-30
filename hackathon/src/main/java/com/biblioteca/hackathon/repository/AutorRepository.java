package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
