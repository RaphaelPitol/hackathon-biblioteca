package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Autor;
import com.biblioteca.hackathon.model.Editora;
import com.biblioteca.hackathon.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editora")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Editoras!");
        model.addAttribute("ListaDeEditoras", editoraService.listarTodos());
        return "editora/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Editora editora) {
        model.addAttribute("boasVindas", "Cadastro de Editoras!");
        return "editora/formulario";
    }

    @PostMapping("/salvar")
    public String salvarAutor(Editora editora) {
        editoraService.salvar(editora);
        return "redirect:/editora/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de Editoras!");
        model.addAttribute("editora", editoraService.buscarPorId(id));
        return "editora/formulario";
    }
    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        editoraService.remover(id);
        return "redirect:/editora/lista";
    }
}
