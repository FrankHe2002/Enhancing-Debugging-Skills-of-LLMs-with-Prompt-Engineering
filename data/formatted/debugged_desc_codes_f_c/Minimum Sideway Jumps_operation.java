Explanation:
The given Java code calculates the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0. The bug in the given code is using `dp[2] * 1` instead of `dp[2] + 1` to assign the value to `dp[1]` in the switch case where `obstacles[i]` is 0. 

Also, erroneous arithmetic operations occur in switch case 0 where min function may incorrectly return `dp[2]` instead of `dp[2] + 1`. It looks as though it should just add 1 to whatever was previously there.			

Fix:
```java
class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[] {1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            switch (obstacles[i]) {
                case 0:
                    dp[0] = min(dp[0], dp[1] + 1, dp[2] + 1);
                    dp[1] = min(dp[0] + 1, dp[1], dp[2] + 1);
                    dp[2] = min(dp[0] + 1, dp[1] + 1, dp[2]);
                    break;
                case 1:
                    dp[0] = Integer.MAX_VALUE;
                    dp[1] = min(dp[1], dp[2] + 1);
                    dp[2] = min(dp[1] + 1, dp[2]);
                    break;
                case 2:
                    dp[0] = min(dp[0], dp[2] + 1);
                    dp[1] = Integer.MAX_VALUE;
                    dp[2] = min(dp[0] + 1, dp[2]); 
                    break;
                case 3:
                    dp[0] = min(dp[0], dp[1] + 1);
                    dp[1] = min(dp[0] + 1, dp[1]);
                    dp[2] = Integer.MAX_VALUE;
                    break;
            }
        }
        return min(dp[0], dp[1], dp[2]);
    }

    int min(int... vals) {
        int min = Integer.MAX_VALUE;
        for (int val : vals) {
            if (val >= 0) min = Math.min(min, val);
        }
        return min;
    }
}
```