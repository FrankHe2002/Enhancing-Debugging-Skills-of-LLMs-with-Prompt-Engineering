```java
import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {
    private Deque<Integer> dq;
    private int max_size;

    public MyCircularDeque(int k) {
        max_size = k;
        dq = new LinkedList<>();
    }

    public boolean insertFront(int value) {
        if (dq.size() < max_size) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dq.size() < max_size) {
            dq.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dq.isEmpty()) {
            dq.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        if (!dq.isEmpty()) {
            return dq.getFirst();
        }
        return -1;
    }

    public int getRear() {
        if (!dq.isEmpty()) {
            return dq.getLast();
        }
        return -1;
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == max_size;
    }
}
```