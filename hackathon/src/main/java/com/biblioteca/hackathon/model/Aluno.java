package com.biblioteca.hackathon.model;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID_ALUNO")
    private Long id;

    private Integer ra;
    @Column(name = "NOME_ALUNO")
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "ID_CURSO")
    private Curso curso;
}
