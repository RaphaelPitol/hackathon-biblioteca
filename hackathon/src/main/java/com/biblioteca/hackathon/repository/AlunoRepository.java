package com.biblioteca.hackathon.repository;

import com.biblioteca.hackathon.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByRa(Integer ra);


}
