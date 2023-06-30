package com.biblioteca.hackathon.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID_LIVRO")
    private Long id;
    private String titulo;
    private String subTitulo;
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name= "ID_EDITORA")
    private Editora editora;
    private String local;
    private Integer ano;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;
    private String imagem;
    private String detalhe;
}
