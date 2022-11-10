package module9;

import java.util.EmptyStackException;

public class Stack {
    private int size;
    private int[] nums;
    private int top;
    public Stack(int initialSize){
        this.size = 0;
        this.nums = new int[initialSize];
        this.top = -1;
    }
    public void push(int data) {
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
        this.nums = new int[size()];
        this.size = 0;
        this.top = -1;
    }
    public int pop() {
        if(!isEmpty()){
            int removedData = peek();
            nums = removeTheElement(nums, top);
            top--;
            size--;

            return removedData;
        }
        throw new EmptyStackException();
    }
    public static int[] removeTheElement(int[] arr, int index) {
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        int[] anotherArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public int peek() {
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
        int[] newArray = new int[newSize];
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
