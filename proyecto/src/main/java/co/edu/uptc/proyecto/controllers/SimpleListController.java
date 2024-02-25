package co.edu.uptc.proyecto.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class SimpleListController {

    @GetMapping("/prueba")
    public String prueba(){
        List <String> prueba = new ArrayList<String>();
        prueba.add("A");
        prueba.add("B");
        prueba.add("C");
        prueba.add("D");

        System.out.println(prueba.remove(3)+ "\n");
        mostrarArray(prueba);
        return "Prueba hecha";
    }

    public void mostrarArray(List<String> prueba){
        for(int i = 0; i < prueba.size(); i++){
            System.out.println(prueba.get(i));
        }
    }
    
}