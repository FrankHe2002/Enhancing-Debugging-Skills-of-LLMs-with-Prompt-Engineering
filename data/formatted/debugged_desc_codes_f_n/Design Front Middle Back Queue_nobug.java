```java
class FrontMiddleBackQueue {

    Deque<Integer> dq1, dq2;

    public FrontMiddleBackQueue() {
        dq1 = new ArrayDeque<Integer>();
        dq2 = new ArrayDeque<Integer>();
    }

    public void pushFront(int val) {
        dq1.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (dq1.size() > dq2.size()) {
            dq2.addFirst(dq1.removeLast());
        }
        dq1.addLast(val);
        balance();
    }

    public void pushBack(int val) {
        dq2.addLast(val);
        balance();
    }

    public int popFront() {
        int val = dq1.isEmpty() ? (dq2.isEmpty() ? -1 : dq2.removeFirst()) : dq1.removeFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        int val = !dq1.isEmpty() ? dq1.removeLast() : (dq2.isEmpty() ? -1 : dq2.removeFirst());
        balance();
        return val;
    }

    public int popBack() {
        int val = dq2.isEmpty() ? (dq1.isEmpty() ? -1 : dq1.removeLast()) : dq2.removeLast();
        balance();
        return val;
    }

    private void balance() {
        if (dq2.size() > dq1.size()) {
            dq1.addLast(dq2.removeFirst());
        }
        if (dq1.size() > dq2.size() + 1) {
            dq2.addFirst(dq1.removeLast());
        }
    }
}
```