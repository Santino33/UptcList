package co.edu.uptc.proyecto.services.enlazadas;

public class UptcList<T> {
    private Nodo<T> header = null;
    
    
    /**
     * Añade un nuevo elemento a la lista
     */
    public void add(T info){
        Nodo nodo = new Nodo();
        nodo.setInfo(info);
        nodo.setNext(null);
        if (header == null) {
            header = nodo;
        }
        else {
            Nodo<T> ultimo = header;
            while(ultimo.getNext()!=null){
                ultimo = ultimo.getNext();
            }
            ultimo.setNext(nodo);
        }
    }

    /**
     * Elimina el ultimo elemento de la lista
    */
    public void remove(){
        Nodo<T> penultimo = header;
        while((penultimo.getNext()).getNext()!= null){
            penultimo = penultimo.getNext();
        }
        penultimo.setNext(null);
    }



    
    public Nodo <T> getHeader(){
        return header;
    }

}
