Please find below the fixed code:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 42.7 MB (Top 19.06%)
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}
```