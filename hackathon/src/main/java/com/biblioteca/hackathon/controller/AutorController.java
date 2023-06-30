package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.model.Autor;
import com.biblioteca.hackathon.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Autores!");
        model.addAttribute("ListaDeAutores", autorService.listarTodos());
        return "autor/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Autor autor) {
        model.addAttribute("boasVindas", "Cadastro de Autores!");
        return "autor/formulario";
    }

    @PostMapping("/salvar")
    public String salvarAutor(Autor autor) {
        autorService.salvar(autor);
        return "redirect:/autor/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de Autores!");
        model.addAttribute("autor", autorService.buscarPorId(id));
        return "autor/formulario";
    }
    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
       autorService.removerPorId(id);
        return "redirect:/autor/lista";
    }
}