package co.edu.uptc.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.proyecto.model.Person;
import co.edu.uptc.proyecto.services.PersonService;
import co.edu.uptc.proyecto.services.enlazadas.Nodo;
import co.edu.uptc.proyecto.services.enlazadas.UptcList;

import java.util.Collections;
import java.util.Comparator;
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
        persona1.setName("David");
        persona1.setLastName("Coulthard");

        Person persona2 = new Person();
        persona2.setName("Max");
        persona2.setLastName("Verstappen");

        Person persona3 = new Person();
        persona3.setName("Lewis");
        persona3.setLastName("Hamilton");

        Person persona4 = new Person();
        persona4.setName("Lando");
        persona4.setLastName("Norris");

        Person persona5 = new Person();
        persona5.setName("Jenson");
        persona5.setLastName("Button");

        Person persona6 = new Person();
        persona6.setName("Alex");
        persona6.setLastName("Albon");

        uptcList.add(persona1);
        uptcList.add(persona2);
        uptcList.add(persona3);
        uptcList.add(persona4);
        uptcList.add(persona5);
        uptcList.add(persona6);

        System.out.println("Antes de comparar");
        showInfo(uptcList);
        compararLista(uptcList);
        System.out.println("\nDespues de comparar");
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

    public void mostrarArray(Object[] array){
        for (Object p : array){
            Person p1 = (Person) p;
            System.out.println(p1.getLastName());
        }
    }

    public void compararLista(List<Person> uptcList){

        Collections.sort(uptcList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }
}
