package co.edu.uptc.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.proyecto.model.Person;
import co.edu.uptc.proyecto.services.PersonService;
import co.edu.uptc.proyecto.services.enlazadas.Nodo;
import co.edu.uptc.proyecto.services.enlazadas.UptcList;

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
        persona3.setLastName("Botero");

        Person persona4 = new Person();
        persona4.setName("Lando");
        persona4.setLastName("Norris");

        uptcList.add(persona1);
        uptcList.add(persona2);
        uptcList.add(persona3);
        uptcList.add(persona4);

        uptcList.remove();

        showInfo(uptcList);

        return "HOLA uptc";
    }

    public void showInfo(UptcList <Person> uptcList ){
        Nodo <Person> nodoImprimible = uptcList.getHeader();
        while (nodoImprimible.getNext() != null) {
            System.out.println(nodoImprimible.getInfo().getName() + ": " + nodoImprimible.getInfo().getLastName());
            nodoImprimible = (Nodo <Person>)nodoImprimible.getNext();
        }
        System.out.println(nodoImprimible.getInfo().getName() + ": " + nodoImprimible.getInfo().getLastName());

    }
}
