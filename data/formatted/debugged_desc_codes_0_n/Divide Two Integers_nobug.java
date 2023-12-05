```java
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        
        long result = 0;
        while (dividendAbs - divisorAbs >= 0) {
            long count = 0;
            while (dividendAbs - (divisorAbs << 1 << count) >= 0) {
                count++;
            }
            result += 1L << count;
            dividendAbs -= divisorAbs << count;
        }
        if (result > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign ? (int) result : (int) -result;
    }
}
```