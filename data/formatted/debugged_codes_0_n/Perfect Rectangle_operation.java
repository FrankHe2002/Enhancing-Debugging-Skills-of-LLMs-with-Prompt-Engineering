```java
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Arrays.sort(rectangles, (r1, r2) -> {
            if (r1[1] == r2[1]) return r1[0] - r2[0];
            return r1[1] - r2[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((r1, r2) -> {
            if (r1[3] == r2[3]) return r1[0] - r2[0];
            return r1[3] - r2[3];
        });

        pq.offer(rectangles[0]);
        int i = 1;
        while (i < rectangles.length && rectangles[i][1] == rectangles[i - 1][1]) {
            if (rectangles[i][0] != rectangles[i - 1][2]) return false;
            pq.offer(rectangles[i++]);
        }

        while (i < rectangles.length) {
            int[] curr = rectangles[i++];
            int x = curr[0];

            while (!pq.isEmpty() && x < curr[2]) {
                int[] prev = pq.poll();
                if (prev[3] != curr[1] || prev[0] != x) return false;
                if (prev[2] > curr[2]) {
                    pq.offer(new int[] { curr[2], prev[1], prev[2], prev[3] });
                    x = curr[2];
                } else {
                    x = prev[2];
                }
            }
            if (x != curr[2]) return false;
            pq.offer(curr);
        }

        int[] prev = pq.poll();
        while (!pq.isEmpty()) {
            if (pq.poll()[3] != prev[3]) return false;
        }

        return true;
    }
}
```