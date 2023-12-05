```java
class Solution {
    public int preimageSizeFZF(int k) {
        long l = 0, r = 5L * (k + 1);
        while (l < r) {
            long m = l + (r - l) / 2;
            int zeros = zeros(m);
            if (zeros < k) {
                l = m + 1;
            } else if (zeros > k) {
                r = m;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private int zeros(long n) {
        int resp = 0;
        while (n > 0) {
            resp += (int) (n / 5);
            n /= 5;
        }
        return resp;
    }
}
```