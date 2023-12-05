The bug in the provided Java code is in the for loop where the stones are added to the PriorityQueue. The index used to access the stones array is incorrect - it should be `stones[i]` instead of `stones[-1]`. 

Here's the fixed code with minimal changes:

```java
// Runtime: 3 ms (Top 42.30%) | Memory: 40.7 MB (Top 84.83%)
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int r1 = pq.poll();
            int r2 = pq.poll();
            if (r1 != r2) pq.add(r1 - r2);
        }
        return (pq.isEmpty()) ? 0 : pq.poll();
    }
}
```

The fix was made by changing `stones[-1]` to `stones[i]` in the for loop. This will correctly add all the stones to the PriorityQueue.