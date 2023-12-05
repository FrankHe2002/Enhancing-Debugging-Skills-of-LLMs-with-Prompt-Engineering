```java
class Solution {
    public int preimageSizeFZF(int k) {
        long left = 0, right = 5L * (k + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            int numZeros = zeros(mid);
            if (numZeros < k) {
                left = mid + 1;
            } else if (numZeros > k) {
                right = mid;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private int zeros(long n) {
        int result = 0;
        while (n > 0) {
            result += (int) (n / 5);
            n /= 5;
        }
        return result;
    }
}
```