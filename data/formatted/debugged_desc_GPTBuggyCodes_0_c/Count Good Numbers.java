Bug type: Logical error in the power function

Reasoning process:
1. The code calculates the total number of good digit strings of length n by calculating the number of good even digits and good odd digits independently.
2. The power function is used to calculate the result of multiplying the good even or odd digits.
3. The bug exists in the power function because it currently returns 0 for any input.

The `power` function needs to be implemented to calculate the result of raising a number to a power.

Fix:

```java
class Solution {
    int mod = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        long first = (n % 2 == 0 ? (n / 2) : (n / 2) + 1);
        long second = n / 2;
        long mul1 = power(5, first) % mod;
        long mul2 = power(4, second) % mod;
        long ans = 1;
        ans = (ans * mul1) % mod;
        ans = (second != 0) ? (ans * mul2) % mod : ans;
        return (int) (ans % mod);
    }

    public long power(long x, long y) {
        if (y == 0) return 1;
        long res = power(x, y / 2) % mod;
        res = (res * res) % mod;
        if (y % 2 == 0) {
            return res;
        } else {
            return (res * x) % mod;
        }
    }
}
```