Fix:
```java
class Solution {
    int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }

    public int countDigitOne(int n) {
        int c = 0;
        for (long i = 1; i <= n; i *= 10) {  // Use long data type for i
            long divider = i * 10;  // Use long data type for divider
            c += (n / divider) * i + Math.min(Math.max((n % divider - i + 1), 0), i);  // Use Math.min and Math.max
        }
        return c;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
```