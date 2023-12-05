```java
class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length, max = -1;

        if (n == 1) {
            if (k % 2 == 1) return -1;
            else return nums[0];
        }

        if (k <= n) {
            for (int i = 0; i < k; i++) {
                max = Math.max(max, nums[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
        }
        
        return max;
    }
}
```