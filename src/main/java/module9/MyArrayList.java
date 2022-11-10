package module9;


import java.util.LinkedList;
import java.util.List;

public class MyArrayList {
    Object arr[];
    List l = new LinkedList();

    int size;
    int capacity;

    public MyArrayList(){
        capacity = 10;
        size = 0;
        arr = new Object[capacity];
    }
    void add(Object item){
        arr[size++] = item;
    }
    Object get(int index) {
        return arr[index];
    }
    int size() {
        return size;
    }

    public Object remove(int index) {
        if ( index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Object removedElement = arr[index];
        for(int i= index; i < size - 1; i++){
            arr[i]= arr[i+1];
        }
        size--;
        return removedElement;
    }

    void clear() {
        for (int to = size, i = size = 0; i < to; i++){
            arr[i] = null;
        }
    }
}

