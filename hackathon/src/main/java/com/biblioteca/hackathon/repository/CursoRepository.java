package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
