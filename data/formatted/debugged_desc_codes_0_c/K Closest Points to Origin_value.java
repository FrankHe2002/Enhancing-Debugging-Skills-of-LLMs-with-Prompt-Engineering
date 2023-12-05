The bug in the provided Java code is in the `calcDistance` method. The calculation of the distance is incorrect due to a typo in the formula. The correct formula for Euclidean distance should be √((x1 - x2)2 + (y1 - y2)2).

Here's the fixed code:

```java
class Solution {
    static class Distance {
        int i;
        int j;
        double dist;

        public Distance(int i, int j, double dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> pq = new PriorityQueue<>((x, y) -> Double.compare(x.dist, y.dist));
        for (int[] point : points) {
            double dist = calcDistance(point[0], point[1]);
            pq.offer(new Distance(point[0], point[1], dist));
        }
        int cnt = 0;
        ArrayList<int[]> l = new ArrayList<>();
        while (cnt < k) {
            Distance d = pq.poll();
            l.add(new int[] {d.i, d.j});
            cnt++;
        }
        int[][] res = l.toArray(new int[l.size()][]);
        return res;
    }

    private double calcDistance(int i, int j) {
        double dist = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2)); // Corrected the formula for Euclidean distance
        return dist;
    }
}
```