package module9;

import java.util.*;


public class MyQueue<T> {
    private T[] arr;      // массив для хранения элементов queue
    private int front;      // front указывает на передний элемент в queue
    private int rear;       // задняя часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    // Конструктор для инициализации queue
    MyQueue(){
        arr = (T[]) new Object[10];
        capacity = 10;
        front = 0;
        rear = -1;
        count = 0;
    }
    // Вспомогательная функция для удаления переднего элемента из очереди
    public T poll() {
        // проверка на опустошение queue
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        T x = arr[front];

        System.out.println("Removing " + x);
        arr = removeTheElement(arr, front);
        front = (front + 1) % capacity;
        front--;
        return x;
    }
    public T[] removeTheElement(T[] arr, int index) {
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
    public void add(T item) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
        System.out.println("Inserting " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
    public T peek() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }

    public int size() {
         return count;
    }

    public boolean isEmpty() {
         return (size() == 0);
    }
    public boolean isFull() {
        return (size() == capacity);
    }
    public void display() {
        System.out.println("Elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public void clear(){
       arr = (T[]) new Object[10];
       capacity = 0;
       front = 0;
       rear = -1;
       count = 0;
    }
}
