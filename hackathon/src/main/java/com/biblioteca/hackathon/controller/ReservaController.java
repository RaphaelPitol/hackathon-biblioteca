package com.biblioteca.hackathon.controller;

import com.biblioteca.hackathon.model.Aluno;
import com.biblioteca.hackathon.model.Reserva;
import com.biblioteca.hackathon.service.AlunoService;
import com.biblioteca.hackathon.service.LivroService;
import com.biblioteca.hackathon.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private LivroService livroService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("boasVindas", "Reservas!");
        model.addAttribute("ListaDeReservas", reservaService.listarTodos());
        return "reserva/lista";
    }
    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Reserva reserva){
        model.addAttribute("boasVindas", "Reservas!");
        model.addAttribute("ListaDeAlunos", alunoService.listarTodos());
        model.addAttribute("ListaDeLivros", livroService.listarTodos());
        return "reserva/formulario";
    }
    @PostMapping("/salvar")
    public String salvarReserva(Reserva reserva){
        reservaService.salvar(reserva);

        return "redirect:/reserva/lista";
    }
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("boasVindas", "Reservas!");
        model.addAttribute("reserva", reservaService.buscarPorId(id));
        model.addAttribute("ListaDeAlunos", alunoService.listarTodos());
        model.addAttribute("ListaDeLivros", livroService.listarTodos());

        return "reserva/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        reservaService.remover(id);
        return "redirect:/reserva/lista";
    }

}
