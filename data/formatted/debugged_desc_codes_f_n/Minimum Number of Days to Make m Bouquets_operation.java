```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE, high = 0;
        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] bloomDay, int maxDays, int m, int k) {
        int count = 0;
        int flowers = 0;
        for (int i : bloomDay) {
            if (i <= maxDays) {
                count++;
                if (count == k) {
                    flowers++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return flowers >= m;
    }
}
```