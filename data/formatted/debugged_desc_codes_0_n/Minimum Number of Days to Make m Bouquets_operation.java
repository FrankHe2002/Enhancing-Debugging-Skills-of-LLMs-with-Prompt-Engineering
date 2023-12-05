```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int low = 1, high = 1000000000;
        while (low < high) {
            int mid = (high - low) / 2 + low, cur = 0, bouquets = 0;
            for (int num : bloomDay) {
                if (num > mid) {
                    cur = 0;
                } else if (++cur == k) {
                    bouquets++;
                    cur = 0;
                }
            }
            if (bouquets < m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
```