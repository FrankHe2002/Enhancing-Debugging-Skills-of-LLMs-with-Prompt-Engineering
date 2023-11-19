Bug Type: Array Index Out Of Bounds

Reasoning: The code uses an array `memo` with a fixed length of 101. However, the loop condition `i < 100` is incorrect. It should be `i < 100-1` because the array indices range from 0 to `length-1`. Since `i` goes up to 99, accessing `memo[j + 1]` in the loop can cause an `ArrayIndexOutOfBoundsException`. Additionally, the `j` loop condition `j >= 0` is not necessary because it is already handled by the `for` loop. 

Fix:
```java
// Champagne Tower
// Leetcode: https://leetcode.com/problems/champagne-tower/

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        double[] memo = new double[101];
        memo[0] = poured;
        for (int i = 0; i < 100-1; i++) {
            for (int j = i; j >= 0; j--) {
                if (memo[j] > 1) {
                    if (i != query_row && j == query_glass) return 1;
                    double val = (memo[j] - 1) / 2;
                    memo[j + 1] += val;
                    memo[j] = val;
                } else {
                    if (i == query_row && j == query_glass) return memo[query_glass];
                    memo[j + 1] += 0;
                    memo[j] = 0;
                }
            }
        }
        return memo[query_glass];
    }
}
```