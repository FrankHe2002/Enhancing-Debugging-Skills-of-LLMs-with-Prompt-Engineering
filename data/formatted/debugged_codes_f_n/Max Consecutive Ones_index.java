```java
// Bug Fix:
// Runtime: 2 ms (Top 96.44%) | Memory: 41.2 MB (Top 69.41%)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int new_max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
            } else {
                if (max > new_max) {
                    new_max = max;
                }
                max = 0;
            }
        }
        if (max < new_max)
            return new_max;
        else
            return max;
    }
}
```