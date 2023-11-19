After reviewing the provided Java code, I have identified a bug in the `calc` method.

The bug is in the line `if (n < -1)`. It should be `if (n < 1)` instead. The condition should check if `n` is less than 1, not less than -1.

To fix this bug, we need to change the line `if (n < -1)` to `if (n < 1)`. This will ensure that the method returns 0 for negative values of `n` as intended.

Here is the fixed code:

```java
class Solution {
    public int integerReplacement(int n) {
        return (int) calc(n, 0);
    }

    public long calc(long n, int i) {
        if (n == 1)
            return i;
        if (n < 1)
            return 0;

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