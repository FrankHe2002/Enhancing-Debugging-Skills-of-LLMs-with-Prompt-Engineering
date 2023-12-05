```java
class Solution {
    public int preimageSizeFZF(int k) {
        long left = 0, right = 5L * (k + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long zeros = zeros(mid);
            if (zeros < k) {
                left = mid + 1;
            } else if (zeros > k) {
                right = mid;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private long zeros(long n) {
        long count = 0;
        for (long d = 5; n / d > 0; d *= 5) {
            count += n / d;
        }
        return count;
    }
}
```