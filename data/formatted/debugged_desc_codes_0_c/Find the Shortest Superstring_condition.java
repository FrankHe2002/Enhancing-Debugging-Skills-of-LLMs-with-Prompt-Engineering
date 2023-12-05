The bug in the provided code is in the innermost loop of the `discount` array calculation. The bug exists in the double for loop that builds the `discount` map. The condition in the loop's header for `j` is incorrect, it is always `true` which causes an infinite loop and incorrect `discount` mapping.

Here's the corrected code:

```java
// Runtime: 66 ms (Top 42.04%) | Memory: 50.5 MB (Top 75.16%)
import java.util.stream.IntStream;

class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] discount = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // corrected condition for inner loop
                if (i == j) continue; // added condition to skip self-comparison
                for (int k = 0; k < words[i].length(); k++) { // build discount map from i->j and j->i
                    if (words[j].startsWith(words[i].substring(k))) {
                        discount[i][j] = words[i].length() - k;
                        break;
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) { // find the max discount for mask (1<<n)-1 with dp
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n && (i & 1 << j) > 0; k++) {
                    if ((i & 1 << k) == 0 && dp[i][j] + discount[j][k] >= dp[i | 1 << k][k]) {
                        dp[i | 1 << k][k] = dp[i][j] + discount[j][k];
                        path[i | 1 << k][k] = j;
                    }
                }
            }
        }
        int m = (1 << n) - 1, idx = n; // build the path from end to start
        int end = IntStream.range(0, n).reduce((a, b) -> dp[(1 << n) - 1][a] > dp[(1 << n) - 1][b] ? a : b).getAsInt();
        String[] ans = new String[n];
        while (m > 0) {
            ans[--idx] = words[end].substring((m & (m - 1)) == 0 ? 0 : discount[path[m][end]][end]);
            m ^= 1 << end;
            end = path[m | 1 << end][end];
        }
        return String.join("", ans);
    }
}
```
After fixing the condition in the innermost loop and adding a check to skip self-comparisons, the code should work properly without causing an infinite loop. You should also import `java.util.stream.IntStream` to use `IntStream` properly.

The fix doesn't change the overall structure of the code but corrects the logical error in the loop condition to build the `discount` map properly.