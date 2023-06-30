package com.biblioteca.hackathon.controller;


import com.biblioteca.hackathon.repository.AlunoExistenteException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlunoExistenteException.class)
    public ModelAndView handleAlunoExistenteException(AlunoExistenteException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error"); // Nome da página de erro
        modelAndView.addObject("message", ex.getMessage()); // Mensagem de erro a ser exibida
        return modelAndView;
    }
}


