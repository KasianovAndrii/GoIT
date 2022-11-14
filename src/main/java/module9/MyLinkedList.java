package module9;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        private T value;
        private Node next;
        public Node(T value) {
            this.value = value;
        }
        public T getData() {
            return this.value;
        }
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public T removeFirst() {
       T val = head.value;
       head = head.next;
       if (head == null) {
          tail = null;
       }
       size--;
       return val;
    }
    public T removeLast() {
        if (size <= 1) {
            return removeFirst();
        }
        Node secondLast = get(size - 2);
        T val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public T remove(int index) {
        if (index == 0) {
           return removeFirst();
        }
        if(index == size - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        T val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public int size() {
        return size;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public T getValue(int index) {
       Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    void addFirst(T val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    void addLast(T val) {
        if (tail == null) {
            addFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void add(T val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next  = node;
        size++;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End LinkedList");
    }
}
