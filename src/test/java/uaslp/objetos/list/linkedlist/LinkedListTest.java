package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class LinkedListTest {
    @Test
    public void whenIsCreated_theItsEmpty(){

        //inicializacion
        LinkedList<String> list = new LinkedList<>();


        //Ejecución
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();


        //Validación
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted(){
        //inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecución
        list.addAtTail("1");

        //Validación
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAnNonEmptyList_whenAddAtTail_thenElementIsInserted(){
        //inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");

        //Ejecución
        list.addAtTail("2");

        //Validación
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertEquals("2", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted(){
        //inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");

        //Ejecución
        list.addAtFront("2");

        //Validación
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("1", list.getAt(1));
        Assertions.assertEquals("2", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenANullValue_whenAddAtFront_thenNotNullAllowedExceptionIsThrown() {
        //inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Validación
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
    }

    @Test
    public void givenANullValue_whenAddAtTail_thenNotNullAllowedExceptionIsThrown() {
        //inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Validación
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
    }

    @Test
    public void givenValidIndex_whenRemove_thenSizeIsDecreased() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);
        list.addAtFront(2);
        list.addAtFront(3);

        // When
        list.remove(1);

        // Then
        Assertions.assertEquals(2, list.getSize());
    }

    @Test
    public void givenValidIndex_whenRemove_thenElementIsRemoved() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);
        list.addAtFront(2);
        list.addAtFront(3);

        // When
        list.remove(1);

        // Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(3, list.getAt(0));
        Assertions.assertEquals(1, list.getAt(1));
    }

    @Test
    public void givenIndexEqualToSize_whenRemove_thenThrowsBadIndexException() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);

        // When
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(1));

        // Then
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void givenNegativeIndex_whenRemove_thenThrowsBadIndexException() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);

        // When
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(-1));

        // Then
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void givenLinkedList_whenRemoveFirst_thenSizeDecreases() throws NotNullAllowedException, BadIndexException {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);
        list.addAtFront(2);
        list.addAtFront(3);
        int expectedSize = 2;

        // When
        list.remove(0);

        // Then
        Assertions.assertEquals(expectedSize, list.getSize());
    }

    @Test
    public void givenLinkedList_whenRemoveLast_thenSizeDecreases() throws NotNullAllowedException, BadIndexException {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtFront(1);
        list.addAtFront(2);
        list.addAtFront(3);
        int expectedSize = 2;

        // When
        list.remove(2);

        // Then
        Assertions.assertEquals(expectedSize, list.getSize());
    }

    @Test
    public void RemoveAllWhitElements() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("element1");
        list.addAtFront("element2");
        list.addAtFront("element3");

        // When
        list.removeAll();

        // Then
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveAllInAEmptyList() {
        // Given
        LinkedList<String> list = new LinkedList<>();

        // When
        list.removeAll();

        // Then
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void setAtWhenIndexIsNull(){
        // Given
        LinkedList<Integer> list = new LinkedList<>();

        // When
        list.addAtFront(10);
        list.addAtFront(20);
        list.addAtFront(30);

        // Then
        list.setAt(1, 50);
        Assertions.assertEquals(50, (int)list.getAt(1));
    }

    @Test
    public void setAtWhenIndexIsOutOfValidRange(){
        // Given
        LinkedList<String> list = new LinkedList<>();

        // When
        list.addAtFront("apple");
        list.addAtFront("banana");

        // Then
        try {
            list.setAt(4, "orange");
            fail("Expected BadIndexException was not thrown");
        } catch (BadIndexException ignored) {

        }
    }

    @Test
    public void setAtWhenDataIsNull(){
        // Given
        LinkedList<Double> list = new LinkedList<>();

        // When
        list.addAtFront(2.5);
        list.addAtFront(3.14);

        // Then
        try {
            list.setAt(1, null);
            fail("Expected NotNullAllowedException was not thrown");
        } catch (NotNullAllowedException ignored) {

        }
    }

    @Test
    public void testRemoveAllWithValueEmptyList() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        // When
        list.removeAllWithValue(5);
        // Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void testRemoveAllWithValueSingleElementNoMatch() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        // When
        list.addAtFront(10);
        list.removeAllWithValue(5);
        // Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(10, (int) list.getAt(0));
    }

    @Test
    public void testRemoveAllWithValueSingleElementMatch() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        // When
        list.addAtFront(5);
        list.removeAllWithValue(5);
        // Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void testRemoveAllWithValueMultipleElementsSomeMatch() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        // When
        list.addAtFront(5);
        list.addAtFront(10);
        list.addAtFront(5);
        list.addAtFront(15);
        list.removeAllWithValue(5);
        // Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(10, (int) list.getAt(0));
    }

    @Test
    public void testRemoveAllWithValueMultipleElementsNoMatch() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        // When
        list.addAtFront(10);
        list.addAtFront(15);
        list.removeAllWithValue(5);
        // Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(15, (int) list.getAt(0));
        Assertions.assertEquals(10, (int) list.getAt(1));
    }


    @Test
    public void testGetIterator() {
        // Given
        LinkedList<String> linkedList = new LinkedList<>();
        // When
        linkedList.addAtFront("A");
        linkedList.addAtFront("B");
        linkedList.addAtFront("C");
        LinkedListIterator<String> iterator = (LinkedListIterator<String>) linkedList.getIterator();
        // Then
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("C", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("B", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("A", iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }


}
