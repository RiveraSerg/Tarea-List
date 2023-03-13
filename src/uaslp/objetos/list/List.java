package uaslp.objetos.list;
public interface List <T>{
    void addAtFront(T data);
    void addAtTail(T data);
    void remove(int index);
    void setAt(int index, T data);
    T getAt(int index);
    void removeAllWithValue(T data);
    int getSize();
    Iterator<T> getIterator();
}
