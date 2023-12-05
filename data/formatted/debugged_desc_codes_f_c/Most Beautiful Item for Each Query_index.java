The bug in the given Java code is its inability to find the largest index of the item with a price less than or equal to the query. Below is the revised function and the full code with the bug fixed.

```java
import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        // sorting the items based on price and then beauty
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1]- a[1];
            }
        });
        int maxBeautySoFar = Integer.MIN_VALUE;
        int[] maxBeauty = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            if (maxBeautySoFar < items[i][1]) maxBeautySoFar = items[i][1];
            maxBeauty[i] = maxBeautySoFar;
        }

        for (int i = 0; i < queries.length; i++) {
            int idx = findLargestIdxWithPriceLessThan(items, queries[i]);
            if (idx != Integer.MIN_VALUE) ans[i] = maxBeauty[idx];
        }
        return ans;
    }

    // refactor the binary search to consider equal to <= and >
    public int findLargestIdxWithPriceLessThan(int[][] items, int price) {
        int l = 0;
        int r = items.length - 1;
        int maxIdxLessThanEqualToPrice = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (items[mid][0] <= price) {
                maxIdxLessThanEqualToPrice = Math.max(maxIdxLessThanEqualToPrice, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return maxIdxLessThanEqualToPrice;
    }
}
```
The changes made include refactoring the binary search to consider the case of equal price (change `if (items[mid][0] > price)` to `if (items[mid][0] <= price)` and switch `>` and `<=` in the binary search condition), and sorting the items based on the price and then beauty to find the maximum beauty where the price is less than or equal to the query.