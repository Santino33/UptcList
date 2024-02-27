package co.edu.uptc.proyecto.controllers;

import java.util.*;

import co.edu.uptc.proyecto.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class SimpleListController {

    @GetMapping("/prueba")
    public String prueba(){
        List <Person> prueba = new ArrayList<Person>();
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

        //prueba.add(persona2);
        prueba.add(persona3);
        prueba.add(persona1);
        prueba.add(persona5);
        prueba.add(persona4);
        System.out.println("Antes de la organizacion");
        mostrarArrayPerson(prueba);
        Collections.sort(prueba, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println("\nDespues de la organizacion");

        System.out.println("Seteado a la posicion 6: "+prueba.set(6, persona2).getLastName());
        mostrarArrayPerson(prueba);
        return "Prueba hecha";
    }

    public void mostrarArrayString(List<String> prueba){
        for(int i = 0; i < prueba.size(); i++){
            System.out.println(prueba.get(i));
        }
    }

    public void mostrarArrayPerson(List<Person> uptcList ){
        Iterator<Person> it = uptcList.iterator();
        int counter = 0;
        while (it.hasNext()){
            System.out.println(it.next().getLastName()+ " -> " + counter);
            counter++;
        }
    }
    
}
