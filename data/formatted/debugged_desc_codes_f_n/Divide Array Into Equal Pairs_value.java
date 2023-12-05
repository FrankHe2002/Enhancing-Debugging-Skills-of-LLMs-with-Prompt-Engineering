```java
// Runtime: 8 ms (Top 41.3%) | Memory: 44.12 MB (Top 12.5%)

class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
```