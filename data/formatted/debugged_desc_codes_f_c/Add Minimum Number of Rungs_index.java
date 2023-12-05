Bug Type: Logical Error

Issue:
1. The condition for initializing the variable `d` is incorrect.
2. The calculation for the number of rungs to add when the distance exceeds `dist` is incorrect.

Fix:
1. Initialize variable `d` based on the condition `i == 0`.
2. Calculate the number of rungs to add based on the excess distance `d` and correct the handling of the condition when `d` is exactly divisible by `dist`.

Fixed Code:
```java
// Runtime: 4 ms (Top 46.95%) | Memory: 72.5 MB (Top 49.39%)
class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        for (int i = 0; i < rungs.length; i++) {
            int d = (i == 0) ? rungs[i] : rungs[i] - rungs[i - 1];
            if (d > dist) {
                ans += (d / dist);
                if (d % dist == 0) {
                    ans--;
                }
            }
        }
        return ans;
    }
}
```