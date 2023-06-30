package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Livro;
import com.biblioteca.hackathon.model.Reserva;
import com.biblioteca.hackathon.service.AutorService;
import com.biblioteca.hackathon.service.CategoriaService;
import com.biblioteca.hackathon.service.EditoraService;
import com.biblioteca.hackathon.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditoraService editoraService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("boasVindas", "Lista de Livros!");
        model.addAttribute("ListaDeLivros", livroService.listarTodos());
        return "livro/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Livro livro){
        model.addAttribute("boasVindas", "Cadastro de Livros!");
        model.addAttribute("ListaDeAutores", autorService.listarTodos());
        model.addAttribute("ListaDeEditoras", editoraService.listarTodos());
        model.addAttribute("ListaDeCategoria", categoriaService.listarTodos());
        return "livro/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Livro livro){
        livroService.salvar(livro);
        return "redirect:/livro/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterarLivro(@PathVariable Long id, Model model){
        model.addAttribute("boasVindas", "Cadastro de Livros!");
        model.addAttribute("livro", livroService.buscarPorId(id));
        model.addAttribute("ListaDeAutores", autorService.listarTodos());
        model.addAttribute("ListaDeEditoras", editoraService.listarTodos());
        model.addAttribute("ListaDeCategoria", categoriaService.listarTodos());
        return "livro/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        livroService.remover(id);
        return "redirect:/livro/lista";
    }

}
