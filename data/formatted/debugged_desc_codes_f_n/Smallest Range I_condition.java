```java
// Runtime: 7 ms (Top 100%) | Memory: 39.5 MB (Top 61.90%)

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int diff = max - min;

        return Math.max(0, diff - 2 * k);
    }
}
```