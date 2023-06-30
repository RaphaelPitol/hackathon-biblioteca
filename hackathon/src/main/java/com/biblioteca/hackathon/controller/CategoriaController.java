package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Autor;
import com.biblioteca.hackathon.model.Categoria;
import com.biblioteca.hackathon.service.AutorService;
import com.biblioteca.hackathon.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Categorias!");
        model.addAttribute("ListaDeCategoria", categoriaService.listarTodos());
        return "categoria/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Categoria categoria) {
        model.addAttribute("boasVindas", "Cadastro de Categorias!");
        return "categoria/formulario";
    }

    @PostMapping("/salvar")
    public String salvarAutor(Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categoria/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de Autores!");
        model.addAttribute("autor", categoriaService.buscarPorId(id));
        return "categoria/formulario";
    }
    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        categoriaService.remover(id);
        return "redirect:/categoria/lista";
    }

}
