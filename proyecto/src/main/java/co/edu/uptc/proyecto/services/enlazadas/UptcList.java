package co.edu.uptc.proyecto.services.enlazadas;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        if (isEmpty()) return 0;

        Nodo temp = header;
        int counter = 1;
        while (temp.getNext() != null){
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
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
        Nodo temp = header;
        Object[] array = new Object[size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = temp.getInfo();
            temp = temp.getNext();
        }
        return array;
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
        Nodo<T> temp = header;
        Nodo<T> before = header;
        while (temp.getNext() != null) {
            before = temp;
            temp = temp.getNext();
            before.setNext(null);
        }
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
        Nodo<T> temp = new Nodo<T>();
        Nodo<T> before = header;
        Nodo<T> replaced = header;
        temp.setInfo(element);

        try{
            if (index == 0) {
                header = temp;
                temp.setNext(replaced.getNext());
            }else{
                for (int i = 0; i < index; i++) {
                    before = replaced;
                    replaced = replaced.getNext();
                    if (replaced == null) {
                        throw new IndexOutOfBoundsException("Index "+ i + " out of bounds " + size());
                    }
                }
                before.setNext(temp);
                temp.setNext(replaced.getNext());
            }

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return replaced.getInfo();
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
    public T remove(int index) {
        Nodo<T> before = header;
        Nodo<T> deleted = header;

        if (deleted == null) {
            throw new NoSuchElementException("The list is empty");
        }
        for(int i =0; i < index; i++){
            before = deleted;
            deleted = deleted.getNext();

            if (deleted == null){
                throw new IndexOutOfBoundsException("Index specified is out of bounds");
            }
        }

        //Evaluar para eliminar el index 0 de la lista
        if (before != deleted){
            before.setNext(deleted.getNext());
        }else {
            header = deleted.getNext();
        }

        return deleted.getInfo();
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
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator();
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
            return actualIndex < size-1;
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

    private class MyListIterator implements ListIterator<T> {
        private int actualIndex;
        private int size;
        private Nodo temp;

        public MyListIterator() {
            actualIndex = 0;
            size = size();
        }


        @Override
        public boolean hasNext() {
            return actualIndex < size-1;
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

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {
            if (temp != null) {
                temp.setInfo(t);
            } else {
                throw new IllegalStateException();
        }


        }

        @Override
        public void add(T t) {

        }
    }


}
