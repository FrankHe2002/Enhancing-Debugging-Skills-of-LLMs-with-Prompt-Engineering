class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> gcdVal = new HashMap<>();
        for (int i = 0; i < n; ++ i) {
            for (int j = i + 1; j < n; ++ j) {
                gcdVal.put((1 << i) + (1 << j), gcd(nums[i], nums[j]));
            }
        }

        int[] dp = new int[1 << n];

        for (int i = 0; i < (1 << n); ++ i) {
            int bits = Integer.bitCount(i);
            if (bits % 2 != 0)
                continue;
            for (int k : gcdVal.keySet()) {
                if ((k & i) != 0)
                    continue;
                dp[i ^ k] = Math.max(dp[i ^ k], dp[i] + gcdVal.get(k) * (bits / 2 + 1));
            }
        }

        return dp[(1 << n) - 1];
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

