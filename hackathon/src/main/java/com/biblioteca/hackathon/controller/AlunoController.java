package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.repository.AlunoExistenteException;
import com.biblioteca.hackathon.service.AlunoService;
import com.biblioteca.hackathon.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("boasVindas", "Lista de Alunos!");
        model.addAttribute("ListaDeAlunos", alunoService.listarTodos());
        return "aluno/lista";
    }
    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Aluno aluno){
        model.addAttribute("boasVindas", "Cadastro de Alunos!");
        model.addAttribute("ListaDeCursos", cursoService.listarTodos());
        return "aluno/formulario";
    }
    @PostMapping("/salvar")
    public String salvarAluno(Aluno aluno, Model model){
        try{
            alunoService.verificarAlunoExistente(aluno.getRa());
            alunoService.salvar(aluno);
            return "redirect:/aluno/lista";

        }catch (AlunoExistenteException ex){
            model.addAttribute("erro", ex.getMessage());
            return iniciarFormulario(model, aluno);
        }
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("boasVindas", "Cadastro de Alunos!");
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        model.addAttribute("ListaDeCursos", cursoService.listarTodos());

        return "aluno/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        alunoService.remover(id);
        return "redirect:/aluno/lista";
    }

}
