package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
