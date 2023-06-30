package com.biblioteca.hackathon.service;


import com.biblioteca.hackathon.model.Livro;
import com.biblioteca.hackathon.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    public LivroRepository livroRepository;

    public Livro salvar(Livro livro){return livroRepository.save(livro);}

    public List<Livro> listarTodos(){return livroRepository.findAll();}

    public Livro buscarPorId(Long id) {return livroRepository.findById(id).get();}
    public void remover(Long id) {livroRepository.deleteById(id);}
}
