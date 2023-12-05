```java
class Solution {

    int INF = 200 * (int) 1e6;

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int dp[][] = new int[nums.length + 1][k + 1];
        memeSet(dp, -1);
        return findMinimumWaste(dp, 0, k, nums);

    }

    int findMinimumWaste(int dp[][], int idx, int k, int nums[]) {
        if (idx == nums.length)
            return 0;
        if (k == -1)
            return INF;

        if (dp[idx][k] != -1)
            return dp[idx][k];

        int ans = INF, max = nums[idx], sum = 0;

        for (int j = idx; j < nums.length; ++j) {
            max = Math.max(max, nums[j]);
            sum += nums[j];
            int totalWasteUptoJ = (j - idx + 1) * max - sum;
            ans = Math.min(ans, totalWasteUptoJ + findMinimumWaste(dp, j + 1, k - 1, nums));

        }

        return dp[idx][k] = ans;
    }

    void memeSet(int dp[][], int val) {
        for (int x[] : dp)
            Arrays.fill(x, val);
    }
}
```