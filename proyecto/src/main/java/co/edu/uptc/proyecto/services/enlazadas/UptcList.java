package co.edu.uptc.proyecto.services.enlazadas;

public class UptcList<T> {
    private Nodo<T> header = null;
    
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


    
    public Nodo <T> getHeader(){
        return header;
    }

}
