```java
// Runtime: 24 ms (Top 24.69%) | Memory: 90.8 MB (Top 76.54%)
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int target = 0, ans = 0;
        boolean[] flip = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && flip[i - k]) {
                target ^= 1;
            }
            if (nums[i] == target) {
                if (i + k > nums.length) {
                    return -1;
                }
                target ^= 1;
                flip[i] = true;
                ans++;
            }
        }
        return ans;
    }
}
```