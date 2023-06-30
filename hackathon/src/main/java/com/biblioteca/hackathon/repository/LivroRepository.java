package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
