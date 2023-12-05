```java
// Runtime: 13 ms (Top 25.2%) | Memory: 50.15 MB (Top 25.4%)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int count = 0;
        int x[] = new int[n + 1];
        int y[] = new int[n + 1];
        Arrays.fill(x, 0);
        Arrays.fill(y, 0);
        for (int i = 0; i < trust.length; i++) {
            x[trust[i][0]] = 1;
            y[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (x[i] != 0)
                count++;
            if (x[i] == 0 && y[i] == n - 1)
                return i;
        }
        return -1;
    }
}
```