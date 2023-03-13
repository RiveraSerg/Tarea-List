package uaslp.objetos.list.arraylist;
import uaslp.objetos.list.Iterator;

public class ArrayListIterator <H>implements Iterator<H> {
    private int i;
    private final Object []currentArray;

    ArrayListIterator(Object []array){
        currentArray = array;
    }
    public boolean hasNext(){
        return currentArray[i] != null;
    }

    public H next(){
        Object data = currentArray[i];
        i++;
        return (H) data;
    }
}
