import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class Main {
    public static void main(String[] args) {
        int index=1;
        int tam;
        String data;

        ArrayList list = new ArrayList();
        ArrayListIterator iterator = list.getIterator();
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtFront("D");
        list.addAtFront("D");
        list.addAtFront("D");

        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");

        }
        tam = list.getSize();
        System.out.println("tamaño: "+tam);


        list.remove(0);
        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");

        }
        tam = list.getSize();
        System.out.println("tamaño: "+tam);

        list.removeAllWithValue("D");
        iterator = list.getIterator();
        while(iterator.hasNext()){
            String dato = iterator.next();
            System.out.print("["+dato+"]<----->");

        }
        tam = list.getSize();
        System.out.println("tamaño: "+tam);

    }
}