```java
class Solution {

    int INF = 200 * (int) 1e6; // according to constarints { 1 <= nums.length <= 200 , 1 >= nums[i] <= 106 }

    public int minSpaceWastedKResizing(int[] nums, int k) {

        int dp[][] = new int[nums.length + 1][k + 1];
        memset(dp, -1);
        return f(dp, 0, k, nums);

    }

    int f(int dp[][], int idx, int k, int nums[]) {
        if (idx == nums.length)
            return 0;
        if (k == -1)
            return INF;

        if (dp[idx][k] != -1)
            return dp[idx][k];

        int ans = INF, max = nums[idx], sum = 0;

        for (int j = idx; j < nums.length; ++ j) {
            max = Math.max(max, nums[j]);
            sum += nums[j];
            int total_waste_upto_j = (j - idx + 1) * max - sum;
            ans = Math.min(ans, total_waste_upto_j + f(dp, j + 1, k - 1, nums));

        }

        return dp[idx][k] = ans;
    }

    void memset(int dp[][], int val) {
        for (int x[] : dp)
            Arrays.fill(x, val);
    }
}

// tc: O(n^2 * k)
// sc: O(n * k)
```