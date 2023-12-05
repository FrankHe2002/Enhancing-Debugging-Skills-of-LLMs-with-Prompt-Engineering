The bug in the given Java code is in the initialization of the 2D array `plants`. The array `plants` is being initialized as `int[n - 1][2]`, which will create an array of size n-1. It should be initialized as `int[n][2]` to store all the plant and grow time data correctly.

Also, the calculation of `maxTime` is incorrect because it doesn't consider the days needed for growing the plants. The correct calculation must consider the time needed to plant the seeds as well as the maximum grow time.

Here's the corrected code:

```java
// Runtime: 168 ms (Top 19.82%) | Memory: 126.2 MB (Top 22.91%)
import java.util.Arrays;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] plants = new int[n][2]; // Corrected the array initialization
        int totalPlantTime = 0;
        for (int i = 0; i < n; i++) {
            plants[i] = new int[] {plantTime[i], growTime[i]};
            totalPlantTime += plantTime[i];
        }
        // Sort plants by grow time.
        // The plant with fewer grow time can be planted at the end.
        Arrays.sort(plants, (a, b) -> a[1] - b[1]);
        // Max grow + plant time
        int maxTime = 0;
        int currentDay = totalPlantTime; // Initialize currentDay with totalPlantTime
        for (int[] plant : plants) {
            maxTime = Math.max(maxTime, currentDay + plant[1]); // Consider the growing time
            currentDay += plant[0]; // Increment currentDay with the plant time
        }
        return maxTime;
    }
}
```