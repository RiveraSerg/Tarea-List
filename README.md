# Tarea-List
## //-------CODIGO PLANTUML------------------------------------
@startuml

title LinkedList - Class Diagram


+class uaslp.objetos.list.linkedlist.LinkedList { <br> 
  -Node head; <br> 
  -Node tail; <br> 
  -int size; <br> 
  <br> 
  +addAtTail (String data) <br> 
  +addAtFront(String data) <br> 
  +remove(index) <br> 
  +removeAll() <br> 
  +setAt(index, data) <br> 
  +getAt(index):String <br> 
  +removeAllWithValue(String data) <br> 
  +getSize(); <br> 
  +getIterator(): LinkedListIterator <br> 
 

} <br> 

~class uaslp.objetos.list.linkedlist.Node{ <br> 
   ~String data; <br> 
   ~Node next; <br> 
   ~Node previous; <br> 
} <br> 

+class uaslp.objetos.list.linkedlist.LinkedListIterator{ <br> 
   +hasNext(): boolean; <br> 
   +next(): String; <br> 
} <br> 


@enduml
