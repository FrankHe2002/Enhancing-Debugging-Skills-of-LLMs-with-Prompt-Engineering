### Fixed Java Code:

```java
// Runtime: 7 ms (Top 73.3%) | Memory: 44.18 MB (Top 74.0%)

import java.util.ArrayDeque;
import java.util.Deque;

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
      if(dq1.size() > dq2.size()) {
        dq2.addFirst(dq1.removeLast());
        dq1.addLast(val);
      } else {
        dq1.addLast(val);
      }
      balanceQueues();
    }

    public int popFront() {
        return popHelper(dq1, dq2);
    }

    public int popMiddle() {
        if(dq1.size() == dq2.size()) {
          return popHelper(dq2, dq1);
        } else {
          return popHelper(dq1, dq2);
        }
    }

    private int popHelper(Deque<Integer> firstQueue, Deque<Integer> secondQueue) {
      if (! firstQueue.isEmpty()) {
          return firstQueue.removeFirst();
      }
      if (! secondQueue.isEmpty()) {
          return secondQueue.removeFirst();
      }
      return -1;
    }

    public int popBack() {
        return popHelper(dq2, dq1);
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