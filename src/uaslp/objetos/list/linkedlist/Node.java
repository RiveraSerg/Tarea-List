package uaslp.objetos.list.linkedlist;

class Node {
    String data;
    Node next;
    Node previous;

    public Node(String d, Node h, Node t) {
        data = d;
        next = h;
        previous = t;
    }

}
