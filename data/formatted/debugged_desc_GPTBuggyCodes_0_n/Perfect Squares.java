```java
class Solution {
    public int numSquares(int n) {

        ArrayList<Integer> perfect_squares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            perfect_squares.add(i * i);
            i++;
        }
        Integer[][] dp = new Integer[n + 1][perfect_squares.size() + 1];
        int answer = helper(n, perfect_squares, perfect_squares.size(), dp);
        return answer;
    }

    public int helper(int n, ArrayList<Integer> coins, int i, Integer[][] dp) {

        if (n == 0) {
            return 0;
        }
        if (i <= 0) {
            return 999999;      
        }
        if (dp[n][i] != null) {
            return dp[n][i];
        }
        int nottake = 9999999;
        if (coins.get(i-1) <= n) {
            nottake = 0 + helper(n, coins, i - 1, dp);
        }
        int take = 9999999;
        if (coins.get(i-1) <= n) {
            take = 1 + helper(n - coins.get(i-1), coins, i-1, dp);
        }
        dp[n][i] = Math.min(nottake, take);
        return dp[n][i];


    }
}
```