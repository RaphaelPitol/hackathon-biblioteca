package com.biblioteca.hackathon.service;

import com.biblioteca.hackathon.model.Autor;
import com.biblioteca.hackathon.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    public AutorRepository autorRepository;

    public Autor salvar(Autor autor){return autorRepository.save(autor);}

    public List<Autor> listarTodos(){return autorRepository.findAll();}

    public Autor buscarPorId(Long id){return autorRepository.findById(id).get();}
    public void removerPorId(Long id){autorRepository.deleteById(id);}
}
