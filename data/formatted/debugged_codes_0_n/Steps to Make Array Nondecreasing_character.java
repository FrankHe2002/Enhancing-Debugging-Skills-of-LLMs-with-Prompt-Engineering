```java
// Runtime: 16 ms (Top 84.34%) | Memory: 56.7 MB (Top 31.96%)

class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = 0;
            while (! stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                cur = Math.max(cur + 1, dp[stack.pop()]);
            }
            stack.push(i);
            dp[i] = cur;
            ans = Math.max(cur + 1, ans);
        }
        return ans;
    }
}
```