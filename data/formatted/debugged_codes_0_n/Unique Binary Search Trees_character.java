```java
class Solution {
    public int numTrees(int n) {
        int[] sol = new int[n + 1];
        sol[0] = 1; // fixed by adding semicolon
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sol[i] += sol[j] * sol[i - j - 1];
            }
        }
        return sol[n];
    }
}
```