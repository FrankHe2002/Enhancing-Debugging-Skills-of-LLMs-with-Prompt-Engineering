The bug in the provided code is the incorrect logic in the delete method for the doubly linked list. The `del` method changes the previous and next nodes' references when removing the specified node, which does not properly update the list if the method is removing the `head` or `tail` nodes.

The fix is to check if the node to be deleted is the head or tail node and adjust the head and tail references accordingly to properly update the list.

Fixed code:
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
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void del(Node newNode) {
        if (newNode.prev == head) {
            head.next = newNode.next;
            newNode.next.prev = head;
        } else if (newNode.next == tail) {
            newNode.prev.next = tail;
            tail.prev = newNode.prev;
        } else {
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
        }
    }
}
```