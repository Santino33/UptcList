package co.edu.uptc.proyecto.services;

import co.edu.uptc.proyecto.model.Person;

public class PersonService {
    
    
    public Person generatePerson(){
        Person person = new Person();
        person.setName("Checo");
        person.setLastName("Perez");
        person.setWeight(60);
        return person;
    }
}
