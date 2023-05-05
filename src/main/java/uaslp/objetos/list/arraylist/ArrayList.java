package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList <T>implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private Object []array;
    private int size;
    public ArrayList(){
        array = new Object[INITIAL_SIZE];
    }
    public void addAtTail(T data) throws NotNullAllowedException{

        if(data == null){
            throw new NotNullAllowedException();
        }

        if(size == array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data) throws NotNullAllowedException{

        if(data == null){
            throw new NotNullAllowedException();
        }

        if(size == array.length){
            increaseSize();
        }
        Object[] newArray = new Object[array.length];
        newArray[0] = data;
        System.arraycopy(array, 0, newArray, 1, array.length - 1);
        array = newArray;

        size++;
    }
    public void remove(int index) throws BadIndexException{

        if(index < 0 || index >= size){
            throw new BadIndexException();
        }

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
    public void setAt(int index, T data) throws NotNullAllowedException, BadIndexException{

        if(index < 0 && index > size){
            throw new BadIndexException();
        }

        if(data == null){
            throw new NotNullAllowedException();
        }

        array[index] = data;
    }
    public T getAt(int index){
        return (T) array[index];
    }
    public void removeAllWithValue(T data){
        if(data.equals(array[0])){
            try {
            remove(0);
            size--;
            }catch(BadIndexException ignored){

            }
        }

        for(int i = 0; i < array.length; i++){
            if(data.equals(array[i])) {
                try {
                    remove(i);
                }catch(BadIndexException ignored){

                }
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
        return new ArrayListIterator<>(array, size);
    }

    public boolean isEmpty(){
        if(array[0]!=null){
            return false;
        }
        else {
            return true;
        }
    }
}

