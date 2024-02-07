package co.edu.uptc.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class person {

    @GetMapping("/persons")
    public void sumar(){
        System.out.println("Hola buenos dias por la mañana");
    }
}