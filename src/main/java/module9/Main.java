package module9;

public class Main {
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Element 1");
        arrayList.add("Element 2");
        arrayList.add("Element 3");
        arrayList.remove(2);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("End ArrayList");
        System.out.println("--------LinkedList--------");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);

        myLinkedList.remove(1);
        myLinkedList.display();

        System.out.println( "Get data by index: " + myLinkedList.getValue(1));
        myLinkedList.clear();
        myLinkedList.display();
        System.out.println("--------Queue--------");
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(10);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        System.out.println("Peek Element: " + myQueue.peek());
        System.out.println("Peek Element: " + myQueue.poll());
        System.out.println("Peek Element: " + myQueue.peek());
        myQueue.display();
        myQueue.clear();
        System.out.println("\nSize: "+ myQueue.size());

        System.out.println("\n"+"--------Stack--------");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(6);
        myStack.push(111);
        myStack.display();

        System.out.println("\nPop: " + myStack.pop());
        myStack.clear();
        myStack.display();
       // HashMap
        System.out.println("\n"+"--------HashMap--------");
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Ann", 19);
        map.put("Sunny", 29);
        map.put("Roman", 39);
        map.display();
        System.out.println("\nGet element: " + map.get("Roman"));
        map.remove("Sunny");
        System.out.println("SIZE : " +map.size());
        map.clear();
    }
}
