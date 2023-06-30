package com.biblioteca.hackathon.service;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.repository.AlunoExistenteException;
import com.biblioteca.hackathon.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    public AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){
        if (!verificarAlunoExistente(aluno.getRa())) {
            return alunoRepository.save(aluno);
        } else {
            throw new AlunoExistenteException("O aluno com o R.A " + aluno.getRa() + " já está cadastrado.");
        }
    }

    public List<Aluno> listarTodos(){return alunoRepository.findAll();}

    public Aluno buscarPorId(Long id) {return alunoRepository.findById(id).get();}

    public void remover(Long id) {alunoRepository.deleteById(id);}

    public boolean verificarAlunoExistente(Integer ra) {
        Aluno aluno = alunoRepository.findByRa(ra);
        return aluno != null;
    }

}
