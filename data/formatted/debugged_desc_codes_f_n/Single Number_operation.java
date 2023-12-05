```java
// Runtime: 1 ms (Top 95.87%) | Memory: 39.2 MB (Top 77.31%)
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
```