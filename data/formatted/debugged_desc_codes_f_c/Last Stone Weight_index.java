Bug type: Logic error

The for loop in the lastStoneWeight function contains a bug. Instead of `stones[-1]`, it should be `stones[i]` to add the stone weights to the priority queue. Additionally, the logic for adding the result of smashing stones back into the priority queue has an error. The condition should be `if (r1 != r2) pq.add(Math.abs(r1 - r2))` to correctly calculate the weight of the remaining stone.

Fix:

```java
// Runtime: 3 ms (Top 42.30%) | Memory: 40.7 MB (Top 84.83%)
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int r1 = pq.poll();
            int r2 = pq.poll();
            if (r1 != r2) pq.add(Math.abs(r1 - r2));
        }
        return (pq.isEmpty()) ? 0 : pq.poll();
    }
}
```