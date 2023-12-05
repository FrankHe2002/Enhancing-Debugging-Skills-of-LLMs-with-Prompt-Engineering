```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                cnt += (nums[j] >> i) & 1;
            }
            total += cnt * (nums.length - cnt);
        }
        return total;
    }
}
```