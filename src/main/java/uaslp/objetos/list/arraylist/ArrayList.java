package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList <T>implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private Object []array;
    private int size;
    public ArrayList(){
        array = new Object[INITIAL_SIZE];
    }
    public void addAtTail(T data){
        if(size == array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data){
        if(size == array.length){
            increaseSize();
        }
        Object[] newArray = new Object[array.length];
        newArray[0] = data;
        System.arraycopy(array, 0, newArray, 1, array.length - 1);
        array = newArray;

        size++;
    }
    public void remove(int index){
        for(int i = index; i+1 < array.length; i++){
            array[i] = array[i+1];
        }
        array[size-1]=null;
        size--;
    }
    public void removeAll(){
        Object[] newArray;
        newArray = new Object[INITIAL_SIZE];
        array = newArray;
        size = 0;
    }
    public void setAt(int index, T data){
        array[index] = data;
    }
    public T getAt(int index){
        return (T) array[index];
    }
    public void removeAllWithValue(T data){
        if(data.equals(array[0])){
            remove(0);
        }

        for(int i = 0; i < array.length; i++){
            if(data.equals(array[i])) {
                remove(i);
            }
        }
    }
    public int getSize(){
        return size;
    }

    private void increaseSize(){
        Object[] newArray = new Object[array.length * 2];

        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }
    public Iterator<T> getIterator() {
        return new ArrayListIterator<>(array);
    }
}

