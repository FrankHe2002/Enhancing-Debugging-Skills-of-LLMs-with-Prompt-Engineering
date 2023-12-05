```java
// Runtime: 0 ms (Top 100.00%) | Memory: 38.3 MB (Top 19.61%)
class Solution {
    public int fib(int n) {

        int[] fiboArray = new int[n + 2];

        fiboArray[0] = 0;
        fiboArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
        }

        return fiboArray[n];

    }
}
```