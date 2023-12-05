This java code has a few issues such as missing imports, and `public:` that are not used in Java. I will remove those and provide an updated version of the code.
```java
import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {
    Deque<Integer> dq;
    int max_size;

    MyCircularDeque(int k) {
        dq = new LinkedList<>();
        max_size = k;
    }

    boolean insertFront(int value) {
        if (dq.size() < max_size) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }

    boolean insertLast(int value) {
        if (dq.size() < max_size) {
            dq.addLast(value);
            return true;
        }
        return false;
    }

    boolean deleteFront() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            return true;
        }
        return false;
    }

    boolean deleteLast() {
        if (!dq.isEmpty()) {
            dq.removeLast();
            return true;
        }
        return false;
    }

    int getFront() {
        return dq.isEmpty() ? -1 : dq.peekFirst();
    }

    int getRear() {
        return dq.isEmpty() ? -1 : dq.peekLast();
    }

    boolean isEmpty() {
        return dq.isEmpty();
    }

    boolean isFull() {
        return dq.size() == max_size;
    }
}
```