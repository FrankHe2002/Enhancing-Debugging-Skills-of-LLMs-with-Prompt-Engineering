```java
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < profit.length; i++) {
            pq.add(new int[] {difficulty[i], profit[i]});
        }
        Arrays.sort(worker);
        int p = 0;
        for (int i = worker.length - 1; i >= 0 && ! pq.isEmpty(); i--) {
            while (! pq.isEmpty() && worker[i] < pq.peek()[0])
                pq.poll();
            if (! pq.isEmpty())
                p = p + pq.poll()[1];
        }
        return p;
    }
}
```