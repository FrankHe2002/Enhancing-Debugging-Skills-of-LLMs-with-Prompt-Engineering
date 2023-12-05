```java
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == - 1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long result = 0;
        while (absDividend - absDivisor >= 0) {
            long count = 0;
            while (absDividend - (absDivisor << 1 << count) >= 0) {
                count++;
            }
            result += 1L << count;
            absDividend -= absDivisor << count;
        }
        return (int)(sign ? result : - result);
    }
}
```