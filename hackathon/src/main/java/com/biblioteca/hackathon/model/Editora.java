package com.biblioteca.hackathon.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="ID_EDITORA")
    private Long id;
    @Column(name = "NOME_EDITORA")
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String telefone;
}
