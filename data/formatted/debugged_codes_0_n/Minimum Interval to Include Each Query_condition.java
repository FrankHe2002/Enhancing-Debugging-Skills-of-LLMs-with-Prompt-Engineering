```java
import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = i;
            q[i][1] = queries[i];
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int[] result = new int[queries.length];
        int j = 0;
        for (int i = 0; i < q.length; i++) {
            int index = q[i][0];
            int val = q[i][1];
            while (j < intervals.length && intervals[j][0] <= val) pq.offer(intervals[j++]);
            while (!pq.isEmpty() && pq.peek()[1] < val) pq.poll();
            result[index] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return result;
    }
}
```