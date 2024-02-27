package co.edu.uptc.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.proyecto.model.Person;
import co.edu.uptc.proyecto.services.PersonService;
import co.edu.uptc.proyecto.services.enlazadas.Nodo;
import co.edu.uptc.proyecto.services.enlazadas.UptcList;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/message")
public class messageController {
    
    /*@GetMapping
    public Person getMessage(){
        PersonService personService = new PersonService();
        return personService.generatePerson();
    }
    */

    @GetMapping("/lista")
    public String getMessage1(){
        UptcList <Person> uptcList = new UptcList<Person>();
    
        Person persona1 = new Person();
        persona1.setName("Checo");
        persona1.setLastName("Perez");

        Person persona2 = new Person();
        persona2.setName("Max");
        persona2.setLastName("Verstappen");

        Person persona3 = new Person();
        persona3.setName("Carlos");
        persona3.setLastName("Sainz");

        Person persona4 = new Person();
        persona4.setName("Lando");
        persona4.setLastName("Norris");

        Person persona5 = new Person();
        persona5.setName("Jenson");
        persona5.setLastName("Button");

        Person persona6 = new Person();
        persona6.setName("George");
        persona6.setLastName("Russell");

        uptcList.add(persona1);
        //uptcList.add(persona2);
        uptcList.add(persona3);
        uptcList.add(persona4);
        uptcList.add(persona5);
        uptcList.add(persona6);

        showInfo(uptcList);
        System.out.println("Piloto reempleazado: "+uptcList.set(5, persona2).getLastName());
        System.out.println("Tamaño: " + uptcList.size() + "\n");
        showInfo(uptcList);

        return "HOLA UPTC";
    }

    public void showInfo(List<Person> uptcList ){
        Iterator<Person> it = uptcList.iterator();
        int counter = 0;
        while (it.hasNext()){
            System.out.println(it.next().getLastName()+ " -> " + counter);
            counter++;
        }
    }
}
