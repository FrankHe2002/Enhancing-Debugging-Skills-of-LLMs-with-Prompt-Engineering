Bug type: Logical Error

Issue:
1. The calculation of the `lcm` (least common multiple) in the `lcm` method is incorrect.
2. There is a potential arithmetic overflow when calculating `ans` in the `lcm` method.

Fix:
1. Correct the logic to calculate the least common multiple (lcm) in the `lcm` method.
2. Handle potential arithmetic overflow when calculating `ans` in the `lcm` method.

Code:
```java
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 0, high = 2 * (int) 1e9;

        long ab = (long)a * b / gcd(a, b);
        long bc = (long)b * c / gcd(b, c);
        long ca = (long)c * a / gcd(c, a);
        long abc = (ab * c) / gcd(ab, c);

        while (low < high) {
            int mid = low + (high - low) / 2;

            long count = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ca + mid / abc;
            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
```