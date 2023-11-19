The bug in the provided Java code is in the innermost for loop:

```java
for (int m = i; m <= k; m--)
```

Here, the loop condition is `m <= k`, which means that the loop will continue as long as `m` is less than or equal to `k`. However, `m` is initialized as `i`, and it is decremented in each iteration. Therefore, if `i` is less than or equal to `k`, the loop will go on indefinitely because `m` will always be less than or equal to `k`. This will lead to an infinite loop and the program will not produce the correct result or terminate.

To fix this bug, we need to change the loop condition to make sure that `m` decrements towards 0. We can modify the loop condition to `m >= k` to ensure that the loop terminates correctly.

Here is the fixed code with the bug fix:

```java
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0, cur = 0;
        for (int k = 0; k < n - 1; k++) { // looking for the fitting row for row k
            for (int i = k; i < n; i++) { // start from row k looking downward
                for (int j = k + 1; j < n; j++) { // all cell after and at k + 1 must be 0
                    if (grid[i][j] == 1)
                        break;
                    if (j < n - 1)
                        continue;
                    for (int m = i; m >= k; m--) { // j == n - 1 here, so we found a valid row
                        int[] tmp = grid[m - 1];  // swap it into the correct row - row k
                        grid[m - 1] = grid[m];
                        grid[m] = tmp;
                        ans++;
                    }
                    i = n;
                }
                if (i == n - 1) // i reaches the end and did not find a fitting row, return -1
                    return - 1;
            }
        }
        return ans;
    }
}
```