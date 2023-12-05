Fix:
```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int[] cnt = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                int idx = (nums[i] >> j) & 1;
                total += cnt[j] - idx;
                cnt[j] += idx;
            }
        }
        return total;
    }
}
```