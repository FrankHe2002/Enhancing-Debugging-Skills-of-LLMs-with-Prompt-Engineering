The buggy part of the code lies in the 'arriveOnTime' method. When calculating the 'time' variable, the loop should iterate up to 'dist.length', not 'dist.length - 1'. And when computing the time of the ith train ride, 'dist[i + 1]' should be used instead of 'dist[i + 2]'. Also, the condition for returning true or false should be modified based on the logic of the problem's requirements. Here is the fixed code:

```java
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
        double time = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[n - 1] / speed;
        return time <= hour;
    }
}
```