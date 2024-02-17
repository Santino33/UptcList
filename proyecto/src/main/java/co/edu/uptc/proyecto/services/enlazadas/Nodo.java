package co.edu.uptc.proyecto.services.enlazadas;
import java.util.Objects;

public class Nodo<T> {

    private T info;
    private Nodo next;


    public Nodo() {

    }

    public Nodo(T info) {
        this.info = info;
    }


    public Nodo(T info, Nodo next) {
        this.info = info;
        this.next = next;
    }



    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getNext() {
        return this.next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    


}