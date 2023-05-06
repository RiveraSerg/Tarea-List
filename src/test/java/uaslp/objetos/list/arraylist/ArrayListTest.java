package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.fail;
public class ArrayListTest {

    @Test
    public void testAddAtTail_ListIsEmpty() {
        // Given
        ArrayList<Integer> list = new ArrayList<Integer>();
        // When
        list.addAtTail(1);
        // Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(1, (int) list.getAt(0));
    }

    @Test
    public void testAddAtTail_ListItsNotEmpty() {
        // Given
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAtTail(1);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(1, (int) list.getAt(0));

        // When
        list.addAtTail(2);

        // Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(1, (int) list.getAt(0));
        Assertions.assertEquals(2, (int) list.getAt(1));

    }

    @Test
    public void testIncreaseSize_AddAtTail() {
        // Given
        ArrayList<Integer> list = new ArrayList<Integer>();
        // When
        for (int i = 1; i <= 10; i++) {
            list.addAtTail(i);
        }
        // Then
        Assertions.assertEquals(10, list.getSize());
    }

    @Test
    public void testIncreaseSize_AddAtFront() {
        // Given
        ArrayList<Integer> list = new ArrayList<Integer>();
        // When
        for (int i = 1; i <= 10; i++) {
            list.addAtFront(i);
        }
        // Then
        Assertions.assertEquals(10, list.getSize());
    }

    @Test
    public void givenANullValue_whenAddAtFront_thenNotNullAllowedExceptionIsThrown(){
        // Given
        ArrayList<Integer> list = new ArrayList<>();
        // Then
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
    }

    @Test
    public void givenANullValue_whenAddAtTail_thenNotNullAllowedExceptionIsThrown() {
        // Given
        ArrayList<Integer> list = new ArrayList<>();

        // Then
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
    }

    @Test
    public void givenIndex_whenRemove_thenElementIsRemovedAndSizeIsUpdated(){
        // Given
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);

        // When
        list.remove(2);

        // Then
        Assertions.assertEquals(Integer.valueOf(1), list.getAt(0));
        Assertions.assertEquals(Integer.valueOf(2), list.getAt(1));
        Assertions.assertEquals(Integer.valueOf(4), list.getAt(2));
        Assertions.assertEquals(3, list.getSize());
    }

    @Test
    public void givenANewArrayList_whenIsEmpty_thenReturnsTrue() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();

        // Validación
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenANonEmptyArrayList_whenIsEmpty_thenReturnsFalse() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);

        // Validación
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWithMultipleElements_whenRemoveAllWithValue_thenAllMatchingElementsAreRemoved() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(2);

        // Ejecución
        list.removeAllWithValue(2);

        // Validación
        Assertions. assertEquals(2, list.getSize());
        Assertions.assertEquals(1, list.getAt(0));
        Assertions.assertEquals(3, list.getAt(1));
    }
    @Test
    public void givenAListWithMatchingElementsAtTheBeginning_whenRemoveAllWithValue_thenMatchingElementsAreRemoved() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(2);

        // Ejecución
        list.removeAllWithValue(1);

        // Validación
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(2, list.getAt(0));
        Assertions.assertEquals(3, list.getAt(1));
        Assertions.assertEquals(2, list.getAt(2));
    }
    @Test
    public void givenAnEmptyList_whenRemoveAllWithValue_thenListRemainsEmpty() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();

        // Ejecución
        list.removeAllWithValue(1);

        // Validación
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWithElements_whenGetIterator_thenIteratorReturnsElementsInCorrectOrder() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);

        // Ejecución
        ArrayListIterator<Integer> iterator = (ArrayListIterator<Integer>) list.getIterator();

        // Validación
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(1, iterator.next().intValue());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(2, iterator.next().intValue());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(3, iterator.next().intValue());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAListWithElements_whenGetSize_thenSizeIsCorrect() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);

        // Ejecución y validación
        Assertions.assertEquals(3, list.getSize());
    }

    @Test
    public void givenAListWithElements_whenRemoveAll_thenListIsEmpty() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);

        // Ejecución
        list.removeAll();

        // Validación
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenANullValue_whenSetAt_thenNotNullAllowedExceptionIsThrown() {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);

        // Ejecución y validación
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.setAt(0, null));
    }

    @Test
    public void givenNegativeIndex_whenSetAt_thenBadIndexExceptionIsThrown() {
        //inicializacion
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);

        //ejecucion y validacion
        Assertions.assertThrows(BadIndexException.class, () -> list.setAt(-1, 2));
    }

    @Test
    public void givenAValidIndexAndData_whenSetAt_thenDataIsSet() throws NotNullAllowedException, BadIndexException {
        // Inicialización
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);

        // Ejecución
        list.setAt(0, 2);

        // Validación
        Assertions.assertEquals(2, (int) list.getAt(0));
    }

    @Test
    public void givenInvalidIndex_whenRemove_thenBadIndexExceptionIsThrown() {
        // Initial setup
        ArrayList<Integer> list = new ArrayList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);

        // Exercise
        try {
            list.remove(3);
            fail("Expected a BadIndexException to be thrown");
        } catch (BadIndexException e) {

        }
    }
}


