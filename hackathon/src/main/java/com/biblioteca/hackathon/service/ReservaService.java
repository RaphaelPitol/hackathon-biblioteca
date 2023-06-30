package com.biblioteca.hackathon.service;


import com.biblioteca.hackathon.model.Reserva;
import com.biblioteca.hackathon.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservaService {
    @Autowired
    public ReservaRepository reservaRepository;

    public Reserva salvar(Reserva reserva){return reservaRepository.save(reserva);}

    public List<Reserva> listarTodos(){return reservaRepository.findAll();}

    public Reserva buscarPorId(Long id) {return reservaRepository.findById(id).get();}
    public void remover(Long id) {reservaRepository.deleteById(id);}

}
