```java
// Runtime: 1 ms (Top 99.97%) | Memory: 46.2 MB (Top 98.87%)

class Solution {

    public void count(int n, int[] a, int k) {
        int i;
        for (i = k; i <= n && i < k * 2; i++) {
            a[i] = a[i - k] + 1;
        }
        if (i > n) {
            return;
        }
        count(n, a, k * 2);
    }

    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        count(n, a, 1);
        return a;
    }
}
```