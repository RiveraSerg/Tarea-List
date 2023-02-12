package uaslp.objetos.list.arraylist;
public class ArrayListIterator {
    private int i;
    private String []currentArray;

    ArrayListIterator(String []array){
        currentArray = array;
    }
    public boolean hasNext(){
        return currentArray[i] != null;
    }

    public String next(){
        String data = currentArray[i];
        i++;
        return data;
    }
}
