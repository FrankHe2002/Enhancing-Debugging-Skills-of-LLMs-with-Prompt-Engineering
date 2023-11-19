```java
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int i = 0; i < m; i++)
            sum += rolls[i];

        int x = (mean * (m + n)) - sum;

        if (x <= 0 || n * 6 < x || ((x / n) == 0)) {
            return new int[] {};
        }

        int[] arr = new int[n];

        int p = x / n, q = x % n;
        for (int i = 0; i < n; i++) {
            arr[i] = p + (q > 0 ? 1 : 0);
            q--;
        }
        return arr;
    }
}
```