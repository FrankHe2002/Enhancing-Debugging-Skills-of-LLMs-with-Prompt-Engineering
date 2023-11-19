```java
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0, cur = 0;
        for (int k = 0; k < n - 1; k++) { 
            for (int i = k; i < n; i++) { 
                for (int j = k + 1; j < n; j++) { 
                    if (grid[i][j] == 1)
                        break;
                    if (j < n - 1)
                        continue;
                    for (int m = i; m > k; m--) { 
                        int[] tmp = grid[m - 1];
                        grid[m - 1] = grid[m];
                        grid[m] = tmp;
                        ans++;
                    }
                    i = n;
                }
                if (i == n - 1) 
                    return -1;
            }
        }
        return ans;
    }
}
```