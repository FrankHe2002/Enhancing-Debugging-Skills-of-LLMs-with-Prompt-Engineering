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
        long ans = 1;
        for (int i = 0; i < y; i++) {
            ans = (ans * x) % mod;
        }
        return ans;
    }
}
```