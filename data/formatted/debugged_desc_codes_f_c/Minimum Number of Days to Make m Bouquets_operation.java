### Fixed Java Code

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int low = 1, high = (int)1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!possibleToMakeBouquet(bloomDay, mid, m, k)) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private boolean possibleToMakeBouquet(int[] bloomDay, int maxDays, int m, int k) {
        int bouquetCount = 0, flowerCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= maxDays) {
                flowerCount++;
                if (flowerCount == k) {
                    bouquetCount++;
                    flowerCount = 0;
                }
            } else {
                flowerCount = 0;
            }
        }
        return bouquetCount >= m;
    }
}
```