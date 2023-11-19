```java
import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : gifts) pq.offer(n);
        int count = 0;
        while (count++ < k && !pq.isEmpty()) pq.offer((int) Math.sqrt(pq.poll()));
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}
```