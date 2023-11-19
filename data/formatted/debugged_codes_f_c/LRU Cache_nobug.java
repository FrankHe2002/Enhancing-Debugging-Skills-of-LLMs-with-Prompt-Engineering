Buggy Code Explanation:
The provided code implements an LRU Cache using a doubly linked list and a hashmap. However, there are a few bugs in the code:
1. The `put` method does not update the value of an existing key if it is already present in the cache. It simply removes the existing key and then inserts the new key-value pair.
2. The `ins` method does not handle the case of inserting a new node when the cache is empty. This causes a NullPointerException when trying to access `head.next` in the `put` method if the cache is initially empty.
3. The `del` method does not handle the case of deleting the first node in the linked list. This causes a NullPointerException when trying to access `newNode.prev` in the `del` method when deleting the first node in the `put` method.

To fix these bugs, the following changes can be made:

```java
class LRUCache {
    class Node {
        int key, value;
        Node next, prev;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> mp;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        mp = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node existing = mp.get(key);
            del(existing);
            ins(existing);
            return existing.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node existing = mp.get(key);
            existing.value = value; // Update the value
            del(existing);
        } else {
            Node newNode = new Node(key, value);
            mp.put(key, newNode);
            ins(newNode);
        }
        if (mp.size() > cap) {
            mp.remove(tail.prev.key);
            del(tail.prev);
        }
    }

    public void ins(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void del(Node newNode) {
        if (newNode == head.next) {
            head.next