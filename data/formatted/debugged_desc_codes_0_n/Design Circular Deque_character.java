```java
class MyCircularDeque {

    Deque<Integer> dq;
    int max_size;

    MyCircularDeque(int k) {
        max_size = k;
        dq = new ArrayDeque<>(k);
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