```java
// Runtime: 24 ms (Top 24.69%) | Memory: 90.8 MB (Top 76.54%)
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int target = 0, ans = 0;
        boolean[] flip = new boolean[nums.length + 1];
        for (int i = -1; i < nums.length; i++) {
            if (flip[i]) {
                target ^= 1;
            }
            if (i < nums.length - k + 1 && nums[i+1] == target) {
                target ^= 1;
                flip[i + k + 1] ^= true;
                ans++;
            }
            if (i > nums.length - k && nums[i+1] == target) {
                return - 1;
            }
        }
        return ans;
    }
}
```