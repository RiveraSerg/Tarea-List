package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node tail;
    private Node head;
    private int size;
    public LinkedList() {
        tail = null;
        head = null;
        size = 0;
    }
    public void addAtFront(String data) {
        if(head != null){
            head = new Node(data, head, null);
            head.next.previous = head;
        }
        else{
            head = tail = new Node(data, null, null);
        }
        size++;
    }
    public void addAtTail(String data){
        if(head != null){
            tail = new Node(data, null, tail);
            tail.previous.next = tail;
        }
        else{
            head = tail = new Node(data, null, null);
        }
        size++;
    }
    public void remove(int index){
        Node aux = head;
        for(int cont = 1; cont<index; cont++){
            aux=aux.next;
        }
        if(aux == head){
            head = head.next;
            head.previous = null;
        }
        else if(aux == tail){
            tail = aux.previous;
            tail.next = null;

        }else{
            aux.previous.next = aux.next;
            aux.next.previous = aux.previous;
        }
        size--;
    }
    public void removeAll(){
      head = null;
      tail = null;
    }
    public void setAt(int index, String data){
        Node aux = head;
        for(int cont = 1; cont<index; cont++){
            aux=aux.next;
        }
        if(aux == head){
            addAtTail(data);
        }
        else if(aux == tail){
            addAtFront(data);
        }else{
            Node nuevo = new Node(data, null, null);
            nuevo.next = aux;
            nuevo.previous = aux.previous;
            aux.previous.next = nuevo;
            aux.previous = nuevo;
        }
        size++;
    }
    public String getAt(int index){
        Node aux = head;
        for(int cont = 1; cont<index; cont++){
            aux=aux.next;
        }
        return aux.data;
    }
    public void removeAllWithValue(String data){
        Node aux = head;
        int cont=0;
        while(aux != null){
            if(data.equals(aux.data)){
                remove(cont);
            }
            cont++;
            aux=aux.next;
        }
    }

    public int getSize(){
        return size;
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator(head);
    }
    }

