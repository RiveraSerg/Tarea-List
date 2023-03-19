@startuml
title LinkedList - Class Diagram<br>

+interface uaslp.objetos.list.List{

+addAtTail (String data) <br>
  +addAtFront(String data)<br>
  +remove(index)<br>
  +removeAll()<br>
  +setAt(index, data)<br>
  +getAt(index):String<br>
  +removeAllWithValue(String data)<br>
  +getSize();<br>
  +getIterator(): Iterator<br>
}<br>

+interface uaslp.objetos.list.Iterator{<br>
+hasNext(): boolean;<br>
   +next(): String;<br>

}<br>

+class uaslp.objetos.list.linkedlist.LinkedList {<br>
  -Node head;<br>
  -Node tail;<br>
  -int size;<br>
 
  +addAtTail (String data)<br>
  +addAtFront(String data)<br>
  +remove(index)<br>
  +removeAll()<br>
  +setAt(index, data)<br>
  +getAt(index):String<br>
  +removeAllWithValue(String data)<br>
  +getSize();<br>
  +getIterator(): Iterator<br>
 

}<br>

~class uaslp.objetos.list.linkedlist.Node{<br>
   ~String data;<br>
   ~Node next;<br>
   ~Node previous;<br>
}<br>

+class uaslp.objetos.list.linkedlist.LinkedListIterator{<br>
   +hasNext(): boolean;<br>
   +next(): String;<br>
}<br>


+class uaslp.objetos.list.arraylist.ArrayListIterator{<br>
   +hasNext(): boolean;<br>
   +next(): String;<br>
}<br>

+class uaslp.objetos.list.arraylist.ArrayList {<br>
  -int size;<br>
  -int size;<br>
 <br>
  +addAtTail (String data)<br>
  +addAtFront(String data)<br>
  +remove(index)<br>
  +removeAll()<br>
  +setAt(index, data)<br>
  +getAt(index):String<br>
  +removeAllWithValue(String data)<br>
  +getSize();<br>
  +getIterator(): Iterator<br>
}<br>
<br>
<br>
Iterator <|-- ArrayListIterator<br>
Iterator <|-- LinkedListIterator<br>
<br>
<br>
List <|-- ArrayList<br>
List <|-- LinkedList<br>
@enduml
