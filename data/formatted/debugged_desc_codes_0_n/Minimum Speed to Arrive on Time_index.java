```java
// Runtime: 343 ms (Top 5.57%) | Memory: 108.2 MB (Top 25.06%)
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int) 1e8;

        while (left < right) {
            int middle = (left + right) / 2;
            if (arriveOnTime(dist, hour, middle))
                right = middle;
            else left = middle + 1;
        }

        return right == (int) 1e8 ? -1 : right;
    }

    private boolean arriveOnTime(int[] dist, double hour, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }
}
```