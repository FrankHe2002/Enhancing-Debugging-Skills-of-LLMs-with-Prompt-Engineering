```java
// Runtime: 16 ms (Top 80.93%) | Memory: 104.9 MB (Top 83.74%)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{points[0][1] - points[0][0], points[0][0]});
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            while (!deque.isEmpty() && x - deque.getFirst()[1] > k) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                ans = Math.max(ans, deque.getFirst()[0] + x + points[i][1]);
            }
            while (!deque.isEmpty() && points[i][1] - points[i][0] >= deque.getLast()[0]) {
                deque.removeLast();
            }
            deque.addLast(new int[]{points[i][1] - points[i][0], points[i][0]});
        }
        return ans;
    }
}
```