Bug type: Logic bug

In the code provided, there is an issue with the calculation of the sum of intervals between elements with the same value. The intervals are not being correctly calculated and accumulated in the output array.

To fix this, we need to update the logic for calculating the sum of intervals. Specifically, we need to fix the calculation of the sumMap and countMap for each unique element in the array.

Here's the corrected code:
```java
// Runtime: 544 ms (Top 6.59%) | Memory: 244.1 MB (Top 25.15%)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] getDistances(int[] arr) {
        long[] output = new long[arr.length];
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; ++ i) {
            if (! sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0L);
                countMap.put(arr[i], 0);
            }

            output[i] += i * countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        sumMap = new HashMap<>();
        countMap = new HashMap<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; -- i) {
            if (! sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0L);
                countMap.put(arr[i], 0);
            }

            output[i] += (len - i - 1) * countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + (len - i - 1));
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        return output;
    }
}
```

In this fixed code:
- Changed the initialization of `sumMap.put(arr[i], 0l)` to `sumMap.put(arr[i], 0L)` to ensure that we use the correct Long value.
- Updated the calculation of `output[i]` in the second loop to correctly calculate the sum of intervals using `*` instead of `+`.

With these changes, the logic bug is fixed, and the code should correctly calculate the intervals and return the desired array.