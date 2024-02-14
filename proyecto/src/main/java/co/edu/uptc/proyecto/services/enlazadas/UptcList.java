package co.edu.uptc.proyecto.services.enlazadas;

public class UptcList<T> {
    private Nodo header = null;
    
    public void add(T info){
        Nodo nodo = new Nodo();
        nodo.setInfo(info);
        nodo.setNext(nodo);

        if (header == null) {
            header = nodo;
        }
        else {
            Nodo ultimo = header;
            while(ultimo.getNext()!=null){
                ultimo = ultimo.getNext();
            }
        }
    }


    
    public Nodo <T> getHeader(){
        return header;
    }

}
