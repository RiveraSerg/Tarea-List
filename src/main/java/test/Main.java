package test;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;

import uaslp.objetos.list.linkedlist.LinkedList;



public class Main {
    public static void main(String[] args) {

        int tam;
        String data;


        List<String> list2 = new ArrayList<>();
        List<String> list1 = new LinkedList<>();
        list2.addAtTail("A");
        list2.addAtTail("B");
        list2.addAtTail("C");
        list2.addAtFront("D");
        list2.addAtFront("D");
        list2.addAtFront("D");

        list1.addAtTail("1");
        list1.addAtTail("2");
        list1.addAtTail("3");
        list1.addAtFront("8");
        list1.addAtFront("7");
        list1.addAtFront("7");


        System.out.print("Lista 2: ");
        printList(list2);
        tam = list2.getSize();
        System.out.println("tamaño: "+tam);

        System.out.print("Lista 1: ");
        printList(list1);
        tam = list1.getSize();
        System.out.println("tamaño: "+tam);

        list1.remove(4);
        list2.remove(4);
        System.out.println("Remover en la posición No. 4: ");

        System.out.print("Lista 2: ");
        printList(list2);
        System.out.println("tamaño: "+tam);

        System.out.print("Lista 1: ");
        printList(list1);
        tam = list1.getSize();
        System.out.println("tamaño: "+tam);

        list1.removeAllWithValue("7");
        list2.removeAllWithValue("D");
        System.out.println("Remover Todos con Valor 7 y D");

        System.out.print("Lista 2: ");
        printList(list2);
        tam = list2.getSize();
        System.out.println("tamaño: "+tam);

        System.out.print("Lista 1: ");
        printList(list1);
        tam = list1.getSize();
        System.out.println("tamaño: "+tam);

        list1.setAt(1,"2");
        list2.setAt(0,"H");
        System.out.println("Colocar en la primera posición 2 y H");


        System.out.print("Lista 2: ");
        printList(list2);
        System.out.println("tamaño: "+tam);


        System.out.print("Lista 1: ");
        printList(list1);
        System.out.println("tamaño: "+tam);

        System.out.println("Obtener la ultima posicion");
        data = list2.getAt(2);
        System.out.println("Lista 2: "+ data);
        data = list1.getAt(3);
        System.out.println("Lista 1: "+ data);

    }

    public static void printList(List<String> list){
        Iterator<String> iterator = list.getIterator();
        System.out.print("Lista 1: ");
        while(iterator.hasNext()){
            Object dato = iterator.next();
            System.out.print("["+dato+"]<----->");
        }
    }
}