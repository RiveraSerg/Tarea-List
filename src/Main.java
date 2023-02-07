import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class Main {
    public static void main(String[] args) {
        int index=1;
        int tam;
        String data;

        LinkedList list = new LinkedList();

        list.addAtTail("B");
        list.addAtTail("A");
        list.addAtTail("A");
        list.addAtFront("C");
        list.addAtFront("D");

        LinkedListIterator iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");
        }
        tam=list.getSize();
        System.out.println("El tamaño es["+tam+"]");

        list.remove(index);

        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");
        }
        tam=list.getSize();
        System.out.println("El tamaño es["+tam+"]");

        data=list.getAt(3);
        System.out.println(data);

        list.setAt(3, "A");
        list.removeAllWithValue("A");

        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");
        }
        tam=list.getSize();
        System.out.println("El tamaño es["+tam+"]");

        list.removeAll();
        list.addAtTail("B");
        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.println("["+dato+"]<----->");
        }

    }
}