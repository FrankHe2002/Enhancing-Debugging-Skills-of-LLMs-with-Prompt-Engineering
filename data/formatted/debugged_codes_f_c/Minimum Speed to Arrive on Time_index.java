Bug Type: Index Out of Bounds

Reasoning: 
The `arriveOnTime` method has an index out of bounds error. In the for loop, the indices used to access `dist` are not within the valid range. The loop condition `i < dist.length - 1` limits the loop iterations up to `dist.length - 2`, but the statement `dist[i + 2]` attempts to access an index beyond the array's bounds. 

Fix: 
Change the loop condition to `i < dist.length - 2`. This ensures that the loop iterates within the valid range of `dist` and fixes the index out of bounds error.

Fixed Code:
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

        return right == (int) 1e8 ? - 1 : right;
    }

    private boolean arriveOnTime(int[] dist, double hour, int speed) {
        int time = 0;
        for (int i = 0; i < dist.length - 2; i++) {
            time += Math.ceil((double) dist[i + 1] / speed);
        }
        return time + (double) dist[dist.length - 1] / speed <= hour;
    }
}
```