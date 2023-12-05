```java
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = 2 * (long) (1e9);

        long ab = lcm(a, b), bc = lcm(b, c), ca = lcm(c, a), abc = lcm(a, bc);

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ca + mid / abc;
            if (count >= n) {
                high = mid;
            } else low = mid + 1;
        }
        return (int) low;
    }

    private long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long temp  = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
```