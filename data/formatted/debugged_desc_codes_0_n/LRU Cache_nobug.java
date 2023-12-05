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
            mp.remove(key);
            del(existing);
        }
        if (mp.size() == cap) {
            mp.remove(tail.prev.key);
            del(tail.prev);
        }
        Node newNode = new Node(key, value);
        ins(newNode);
        mp.put(key, head.next);
    }

    public void ins(Node newNode) {
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    public void del(Node newNode) {
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;
    }
}
```