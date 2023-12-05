```java
// Runtime: 7 ms (Top 73.3%) | Memory: 44.18 MB (Top 74.0%)

class FrontMiddleBackQueue {

    Deque<Integer> dq1, dq2;

    public FrontMiddleBackQueue() {
        dq1 = new ArrayDeque<Integer>();
        dq2 = new ArrayDeque<Integer>();
    }

    public void pushFront(int val) {
        dq1.addFirst(val);
        balanceQueues();
    }

    public void pushBack(int val) {
        dq2.addLast(val);
        balanceQueues();
    }

    public void pushMiddle(int val) {
        dq1.addLast(val);
        balanceQueues();
    }

    public int popFront() {
        if (! dq1.isEmpty())
            return dq1.removeFirst();
        if (! dq2.isEmpty())
            return dq2.removeFirst();
        return - 1;
    }

    public int popMiddle() {
        if (dq1.isEmpty() && dq2.isEmpty())
            return - 1;
        if (dq1.size() == dq2.size()) {
            int res = dq1.removeLast();
            balanceQueues();
            return res;
        } else {
            int res = dq2.removeFirst();
            balanceQueues();
            return res;
        }
    }

    public int popBack() {
        if (! dq2.isEmpty())
            return dq2.removeLast();
        if (! dq1.isEmpty())
            return dq1.removeLast();
        return - 1;
    }

    private void balanceQueues() {
        if (dq1.size() > dq2.size() + 1) {
            dq2.addFirst(dq1.removeLast());
        } else if (dq2.size() > dq1.size()) {
            dq1.addLast(dq2.removeFirst());
        }
    }
}
```