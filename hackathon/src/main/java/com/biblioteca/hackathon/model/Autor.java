package com.biblioteca.hackathon.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="ID_AUTOR")
    private Long id;
    @Column(name="NOME_AUTOR")
    private String nome;
    private  String endereco;
    private String cidade;
    private String uf;
    private String telefone;
}
