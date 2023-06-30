package com.biblioteca.hackathon.service;

import com.biblioteca.hackathon.model.Autor;
import com.biblioteca.hackathon.model.Curso;
import com.biblioteca.hackathon.repository.AutorRepository;
import com.biblioteca.hackathon.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    public CursoRepository cursoRepository;

    public Curso salvar(Curso curso){return cursoRepository.save(curso);}

    public List<Curso > listarTodos(){return cursoRepository.findAll();}

    public Curso buscarPorId(Long id){return cursoRepository.findById(id).get();}
    public void remover(Long id){cursoRepository.deleteById(id);}
}
