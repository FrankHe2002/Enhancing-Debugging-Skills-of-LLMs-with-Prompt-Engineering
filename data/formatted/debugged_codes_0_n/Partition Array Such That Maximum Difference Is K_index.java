```java
class Solution {
    
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 1, prev = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[prev] > k) {
                c++;
                prev = i + 1;
            }
        }
        return c;
    }
}
```