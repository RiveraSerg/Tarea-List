package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList <T>implements List <T>{
    private Node<T> tail;
    private Node<T> head;
    private int size;
    public LinkedList() {
        tail = null;
        head = null;
        size = 0;
    }
    public void addAtFront(T data) throws NotNullAllowedException {
        if(data == null){
            throw new NotNullAllowedException();
        }

        if(head != null){
            head = new Node<>(data, head, null);
            head.next.previous = head;
        }
        else{
            head = tail = new Node<>(data, null, null);
        }
        size++;
    }
    public void addAtTail(T data) throws NotNullAllowedException{
        if(data == null){
            throw new NotNullAllowedException();
        }

        if(head != null){
            tail = new Node<>(data, null, tail);
            tail.previous.next = tail;
        }
        else{
            head = tail = new Node<>(data, null, null);
        }
        size++;
    }
    public void remove(int index) throws BadIndexException {
        if (index < 0 || index >= size) {
            throw new BadIndexException();
        }

        Node<T> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        if (aux == head) {
            head = aux.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (aux == tail) {
            tail = aux.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            aux.previous.next = aux.next;
            aux.next.previous = aux.previous;
        }

        size--;
    }

    public void removeAll(){
      head = null;
      tail = null;
      size = 0;
    }

    public void setAt(int index, T data) throws NotNullAllowedException, BadIndexException {
        if (index < 0 || index >= size) {
            throw new BadIndexException();
        }

        if (data == null) {
            throw new NotNullAllowedException();
        }

        Node<T> aux = head;
        for (int cont = 0; cont < index; cont++) {
            aux = aux.next;
        }

        aux.data = data;
    }

    public T getAt(int index)throws BadIndexException{
        if(index < 0 && index > size){
            throw new BadIndexException();
        }

        Node<T> aux = head;
        for(int cont = 0; cont<index; cont++){
            aux=aux.next;
        }
        return aux.data;
    }
    public void removeAllWithValue(Object data){
        Node<T> aux = head;
        int cont=0;
        while(aux != null){
            if(data.equals(aux.data))
                    remove(cont);

            aux=aux.next;
        }
    }

    public int getSize(){
        return size;
    }

    public Iterator<T> getIterator() {
        return new LinkedListIterator<>(head);
    }

    public boolean isEmpty(){
        if(head != null){
            return false;
        }
        else
            return true;
    }



    }



