package co.edu.uptc.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class messageController {
    
    @GetMapping
    public String getMessage(){
        System.out.println("Hola buenos dias por la mañana");
        return "Hola buenos dias por la mañana";
    }
}
