package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Curso;
import com.biblioteca.hackathon.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("boasVindas", "Lista de Cursos!");
        model.addAttribute("ListaDeCursos", cursoService.listarTodos());
        return "curso/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Curso curso){
        model.addAttribute("boasVindas", "Cadastro de Cursos!");

        return "curso/formulario";
    }
    @PostMapping("/salvar")
    public String salvarCurso(Curso curso){
        cursoService.salvar(curso);

        return "redirect:/curso/lista";
    }
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("boasVindas", "Cadastro de Cursos!");
        model.addAttribute("curso", cursoService.buscarPorId(id));

        return "curso/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model){
        cursoService.remover(id);
        return "redirect:/curso/lista";
    }

}
