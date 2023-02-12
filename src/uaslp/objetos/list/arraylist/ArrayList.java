package uaslp.objetos.list.arraylist;

public class ArrayList {
    private static final int INITIAL_SIZE = 2;
    private String []array;
    private int size;
    public ArrayList(){
        array = new String[INITIAL_SIZE];
    }
    public void addAtTail(String data){
        if(size == array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(String data){
        if(size == array.length){
            increaseSize();
        }
        String[] newArray = new String[array.length];
        newArray[0] = data;
        for(int i = 1; i < array.length; i++){
            newArray[i] = array[i-1];
        }
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
        String[] newArray = new String[INITIAL_SIZE];
        array = newArray;
        size = 0;
    }
    public void setAt(int index, String data){
        array[index] = data;
    }
    public String getAt(int index){
        return array[index];
    }
    public void removeAllWithValue(String data){
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
        String[] newArray = new String[array.length * 2];

        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;

    }
    public ArrayListIterator getIterator() {
        return new ArrayListIterator(array);
    }
}

