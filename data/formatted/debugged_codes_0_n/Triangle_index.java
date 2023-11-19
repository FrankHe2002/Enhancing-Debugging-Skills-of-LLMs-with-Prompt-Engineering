```java
// Runtime: 2 ms (Top 98.03%) | Memory: 39.1 MB (Top 98.57%)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
```