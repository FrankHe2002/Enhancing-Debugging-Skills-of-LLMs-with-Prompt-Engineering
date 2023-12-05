The bug in the code is that the condition `if (n < -1)` is not necessary and should be removed. Additionally, as the result needs to be an int, the type should be cast to int after the calculation is complete.

Fixed code:

```java
class Solution {
    public int integerReplacement(int n) {
        return (int) calc(n, 0);
    }

    public long calc(long n, int i) {
        if (n == 1)
            return i;

        long a = Long.MAX_VALUE, b = Long.MAX_VALUE, c = Long.MAX_VALUE;

        if (n % 2 == 0)
            a = calc(n / 2, i + 1);
        else {
            b = calc(n - 1, i + 1);
            c = calc(n + 1, i + 1);
        }
        long d = Math.min(a, Math.min(b, c));
        return d;
    }
}
```