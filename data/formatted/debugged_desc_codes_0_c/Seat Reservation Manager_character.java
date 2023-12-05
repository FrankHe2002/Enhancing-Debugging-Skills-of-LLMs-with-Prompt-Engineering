The bug in the provided code is a syntax error in the unreserve() method. The opening parenthesis in the method signature is missing, and also pq is not initialized correctly in the SeatManager constructor. 

To fix the bug, you should initialize the PriorityQueue with the initial capacity as n in the SeatManager constructor. Then, in the unreserve() method, add the missing closing parenthesis to the method signature.

Here's the fixed code:

```java
// Runtime: 88 ms (Top 72.91%) | Memory: 105 MB (Top 67.49%)
import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        count = 1;
        pq = new PriorityQueue<Integer>();
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        if (pq.size() == 0)
            return count++;

        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
```