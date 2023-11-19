```java
import java.util.HashMap;
import java.util.Map;

class LFUCache {
    // Declare Node class for Doubly Linked List 
    class Node {
        int key, value, freq;// to store key,value and frequency
        Node prev, next;// Next and Previous Pointers

        Node(int k, int v) {
            // initializing in constructor
            key = k;
            value = v;
            freq = 1;
        }

    }

    // Declare class for List of Doubly Linked List
    class List {
        int size;
        Node head, tail;

        List() {
            // initializing in constructor
            size = 0;
            head = new Node(- 1, - 1);// Default values
            tail = new Node(- 1, - 1);
            head.next = tail;
            tail.prev = head;
        }

        // To insert at the start of the list
        void ins(Node newNode) {
            Node temp = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
            size++;

        }

        // To delete specific node
        void del(Node newNode) {
            Node pr = newNode.prev;
            Node nx = newNode.next;
            pr.next = nx;
            nx.prev = pr;
            size--;
        }
    }

    Map<Integer, Node> mp;// to store key and Node
    Map<Integer, List> listMap;// to store frequency and Doubly Linked List
    int maxSize, minFreq, currSize;// to store total size , minimum frequency and current size of the list

    public LFUCache(int capacity) {
        // initializing in constructor
        maxSize = capacity;
        minFreq = 0;
        currSize = 0;
        mp = new HashMap<Integer, Node>();
        listMap = new HashMap<Integer, List>();
    }

    public int get(int key) {
        // if map contains the specific key 
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            int val = node.value;
            updateFreq(node);// to update the frequency of the node
            return val;
        }
        //otherwise
        return - 1;
    }

    public void put(int key, int value) {
        // one of the corner case
        if (maxSize == 0)
            return;
        // if map contains the specific key 
        if (mp.containsKey(key)) {
           