package module9;

public class MyHashMap<K, V> {

    private Node<K,V>[] table;
    private int capacity= 10;
    private int SIZE = 0;



    public MyHashMap(){
        table = new Node[capacity];
    }

    public void put(K newKey, V data){
        if(newKey==null)
            return;


        int hash=hash(newKey);

        Node<K,V> newNode = new Node<K,V>(newKey, data, null);


        if(table[hash] == null){
            table[hash] = newNode;
            SIZE++;
        }else{
            Node<K,V> previous = null;
            Node<K,V> current = table[hash];

            while(current != null){
                if(current.key.equals(newKey)){
                    if(previous==null){
                        newNode.next=current.next;
                        table[hash]=newNode;
                        SIZE++;
                        return;
                    }
                    else{
                        newNode.next=current.next;
                        previous.next=newNode;
                        SIZE++;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            SIZE++;
            previous.next = newNode;
        }
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Node<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }


    public boolean remove(K deleteKey){

        int hash=hash(deleteKey);

        if(table[hash] == null){
            return false;
        }else{
            Node<K,V> previous = null;
            Node<K,V> current = table[hash];

            while(current != null){
                if(current.key.equals(deleteKey)){
                    if(previous==null){  //delete first entry node.
                        table[hash]=table[hash].next;
                        SIZE--;
                        return true;

                    }
                    else{
                        previous.next=current.next;
                        SIZE--;
                        return true;
                    }
                }
                previous=current;
                current = current.next;
            }
            return false;
        }

    }
    public int size() {
        return SIZE;
    }
    public void clear() {
        table = new Node[capacity];
    }
    public void display(){

        for(int i=0; i<capacity; i++){
            if(table[i]!=null){
                Node<K, V> entry=table[i];
                while(entry!=null){
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
                }
            }
        }

    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}