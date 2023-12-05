```java
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;

        int nums[] = new int[n + 1];
        nums[0] = 0;

        int max = 1;

        for (int i = 1; i <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
                max = Math.max(max, nums[2 * i]);
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
        }
        return max;
    }
}
```