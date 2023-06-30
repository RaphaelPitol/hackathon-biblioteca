package com.biblioteca.hackathon.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="ID_CURSO")
    private Long id;
    @Column(name = "NOME_CURSO")
    private String nome;

    private String coordenador;

    private Integer duracao;
}
