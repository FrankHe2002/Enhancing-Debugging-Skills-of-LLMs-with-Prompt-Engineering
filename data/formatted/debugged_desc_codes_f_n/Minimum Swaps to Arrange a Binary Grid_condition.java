```java
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        for (int k = 0; k < n; k++) {
            int cur = 0;
            for (int i = k; i < n; i++) {
                if (grid[i][k] == 0) {
                    int[] tmp = grid[k];
                    grid[k] = grid[i];
                    grid[i] = tmp;
                    cur = 1;
                    ans += i - k;
                    break;
                }
            }
            if (cur == 0)
                return -1;
        }
        return ans;
    }
}
```