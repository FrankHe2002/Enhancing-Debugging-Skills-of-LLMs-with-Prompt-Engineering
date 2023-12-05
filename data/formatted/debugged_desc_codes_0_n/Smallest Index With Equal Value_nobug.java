```java
// Runtime: 1 ms (Top 100.00%) | Memory: 42.3 MB (Top 94.74%)
class Solution {
    public int smallestEqual(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
```