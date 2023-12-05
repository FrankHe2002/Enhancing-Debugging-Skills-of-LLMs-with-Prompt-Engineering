```java
class Solution {
    public int integerReplacement(int n) {
        return calc(n, 0);
    }

    public int calc(long n, int i) {
        if (n == 1)
            return i;
        if (n % 2 == 0)
            return calc(n / 2, i + 1);
        else
            return Math.min(calc(n - 1, i + 1), calc(n + 1, i + 1));
    }
}
```