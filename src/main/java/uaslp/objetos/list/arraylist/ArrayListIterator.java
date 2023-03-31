package uaslp.objetos.list.arraylist;
import uaslp.objetos.list.Iterator;

public class ArrayListIterator <H>implements Iterator<H> {
    private int i;
    private int size;
    private final Object []currentArray;

    ArrayListIterator(Object []array, int size){
        currentArray = array;
        this.size = size;
    }
    public boolean hasNext(){
        return size > i;
    }

    public H next(){
        Object data = currentArray[i];
        i++;
        return (H) data;
    }
}
