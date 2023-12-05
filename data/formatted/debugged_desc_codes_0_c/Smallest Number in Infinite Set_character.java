The given Java code contains a bug. The bug is in the `popSmallest` method where if the size of the priority queue `q` is greater than 0, then the smallest element should be returned by `q.poll()`, but it is missing a closing bracket before `return index++;` which causes the bug. Additionally, the `is_in_q` method can be optimized using the `contains` method of the PriorityQueue class.

Here's the fixed code:

```java
import java.util.PriorityQueue;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> q;
    private int index;

    public SmallestInfiniteSet() {
        q = new PriorityQueue<Integer>();
        index = 1;
    }

    public int popSmallest() {
        if (q.size() > 0) {
            return q.poll();
        }
        return index++;
    }

    public void addBack(int num) {
        if (num < index && !q.contains(num)) {
            q.add(num);
        }
    }
}
```

The changes made are:
1. Added a closing bracket after `return q.poll();` in the `popSmallest` method to properly handle the case when the priority queue is not empty.
2. Removed the `is_in_q` method and used the `contains` method of the PriorityQueue class directly in the `addBack` method for better optimization.