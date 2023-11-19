```java
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long N = (long) n;
        long A = (long) a;
        long B = (long) b;
        long mod = 1000000007;
        long low = 2;
        long high = (long)1e15;
        long ans = -1;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            long x = mid / A + mid / B - mid / lcm(A, B);
            if (x >= N) {
                ans = mid;
                high = mid - 1;
            } else if (x < N) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        ans = ans % mod;
        return (int) ans;
    }

    long lcm(long a, long b) {
        long tmpA = a;
        long tmpB = b;
        while (a > 0) {
            long temp = a;
            a = b % a;
            b = temp;
        }

        return tmpA * tmpB / b;
    }
}
```