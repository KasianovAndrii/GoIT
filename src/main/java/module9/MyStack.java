package module9;

import java.util.EmptyStackException;

public class MyStack<T> {
    private int size;
    private T[] nums;
    private int top;
    public MyStack(){
        this.size = 0;
        this.nums = (T[]) new Object[10];
        this.top = -1;
    }
    public void push(T data) {
        if (isFull()) {
            resize();
        }
        nums[++top] = data;
        size++;
    }
    public int size() {
        return size;
    }
    public void clear(){
        this.size = 0;
        this.nums = (T[]) new Object[10];
        this.top = -1;
    }
    public T pop() {
        if(!isEmpty()){
            T removedData = peek();
            nums = removeTheElement(nums, top);
            top--;
            size--;

            return removedData;
        }
        throw new EmptyStackException();
    }
    public  T[] removeTheElement(T[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        T[] anotherArray = (T[]) new Object[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public T peek() {
        if(!isEmpty()){
            return nums[top];
        }
        throw new EmptyStackException();
    }
    public boolean isEmpty() {
        return top < 0;
    }
    private boolean isFull() {
        return size == nums.length;
    }
    private void resize() {
        int newSize = nums.length*2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        nums = newArray;
    }
    public void display() {
        System.out.println("Elements: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
