package com.biblioteca.hackathon.service;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.model.Curso;
import com.biblioteca.hackathon.model.Editora;
import com.biblioteca.hackathon.repository.AlunoRepository;
import com.biblioteca.hackathon.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    @Autowired
    public EditoraRepository editoraRepository;

    public Editora salvar(Editora editora){return editoraRepository.save(editora);}

    public List<Editora> listarTodos(){return editoraRepository.findAll();}

    public Editora buscarPorId(Long id) {return editoraRepository.findById(id).get();}
    public void remover(Long id) {editoraRepository.deleteById(id);}

}
