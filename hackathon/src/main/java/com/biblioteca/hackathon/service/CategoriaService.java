package com.biblioteca.hackathon.service;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.model.Categoria;
import com.biblioteca.hackathon.repository.AlunoRepository;
import com.biblioteca.hackathon.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria){

        return categoriaRepository.save(categoria);}

    public List<Categoria> listarTodos(){return categoriaRepository.findAll();}

    public Categoria buscarPorId(Long id) {return categoriaRepository.findById(id).get();}
    public void remover(Long id) {categoriaRepository.deleteById(id);}

}
