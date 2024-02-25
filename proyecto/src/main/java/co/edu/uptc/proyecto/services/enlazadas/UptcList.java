package co.edu.uptc.proyecto.services.enlazadas;

import java.util.*;

public class UptcList<T> implements List<T>{
    private Nodo<T> header;
    private Nodo<T> footer;
    

    public UptcList() {
        header = null;
    }


    /**
     * Elimina el ultimo elemento de la lista
    */
    public void remove(){
        Nodo<T> penultimate = header;
        while((penultimate.getNext()).getNext()!= null){
            penultimate = penultimate.getNext();
        }
        penultimate.setNext(null);
    }
    

    public Nodo<T> setFooterToLastElement(){
        footer = header;
        while (footer.getNext() != null) {
            footer = footer.getNext();
        }
        return footer;
    }
    
    public Nodo <T> getHeader(){
        return header;
    }



    @Override
    public int size() {
        Nodo temp = header;
        int counter = 0;
        while (temp.getNext() != null){
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        Nodo<T> temp = header;
        Boolean result = false;
        while (!result && temp.getNext() != null) {
            if (o.equals(temp.getInfo())) result = true;
            else temp = temp.getNext();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public T get(int pos) {
        Nodo<T> aux = header;
        for (int i = 0; i < pos; i++) {
            aux = aux.getNext();
        }
        return (T) aux.getInfo();
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, T element) {
        Nodo <T> temp = new Nodo<T>();
        Nodo <T> aux = header;
        temp.setInfo(element);

        try{
            for(int i =0; i < index +1 ; i++){
                if (i == index -1) {
                    temp.setNext(aux.getNext());
                    aux.setNext(temp);
                }
                else if (i == index && i == 0){
                    header = temp;
                    temp.setNext(aux);
                }
                else{
                    aux = aux.getNext();
                }
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public T remove(int pos) {
        Nodo<T> before = header;
        Nodo<T> elementDeleted = header;
        int index = 0;
        boolean found = false;

        while(index < pos && elementDeleted.getNext()!=null && !found){
            //Verifica si el elemento a eliminar es el primero o el ultimo de la lista
            if ((index == pos && index == 0) || (index == pos && elementDeleted.equals(footer))) {
                System.out.println("");
                before.setNext(null); 
                found = true;
            }
            else if (index == pos){
                elementDeleted.setNext(null);
                before.setNext(elementDeleted.getNext());
                found = true;
            }
            else if (index == 0){
                elementDeleted = elementDeleted.getNext();
            }
            else{
                before = elementDeleted;
                elementDeleted = elementDeleted.getNext();
            }
        }
        if(found) throw new IndexOutOfBoundsException();
        return elementDeleted.getInfo();
    }
        

    @Override
    public int indexOf(Object o) {
        Nodo temp = header;
        boolean found = false;
        int index = 0;

        while (!found && temp != null){
            if (o.equals(temp.getInfo())) {
                found = true;
            }
            else {
                temp = temp.getNext();
                index++;
            }
        }
        if (!found) index = -1;
        return index;

    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public boolean add(T e) {
        boolean added = false;
        Nodo temp = new Nodo();
        temp.setInfo(e);
        temp.setNext(null);
        if (header == null) {
            header = temp;
        }
        else {
            Nodo<T> ultimo = header;
            while(ultimo.getNext()!=null){
                ultimo = ultimo.getNext();
                footer = ultimo;
            }
            ultimo.setNext(temp);
            added = true;
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    private Nodo findNode(int index){
        Nodo temp = header;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public Nodo findNode(Object o){
        Nodo temp = header;
        boolean found = false;
        while(found && temp.getNext() != null){
            if (o.equals(temp.getInfo())){
                found = true;
            }else temp = temp.getNext();
        }
        return temp;
    }



    private class MyIterator implements Iterator<T>{

        private int actualIndex;
        private int size;
        private Nodo temp;
        public MyIterator() {
            actualIndex = 0;
            size = size();
        }

        @Override
        public boolean hasNext() {
            return actualIndex < size;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("There are no more elements");
            } else if (temp == null) {
                temp = header;
                return (T) temp.getInfo();
            }
            actualIndex++;
            temp = temp.getNext();
            return (T)(temp.getInfo());
        }
    }


}
