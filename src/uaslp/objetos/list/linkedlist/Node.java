package uaslp.objetos.list.linkedlist;

class Node <O>{
    O data;
    Node<O> next;
    Node<O> previous;

    public Node(O data, Node h, Node t) {
        this.data = data;
        next = h;
        previous = t;
    }

}
