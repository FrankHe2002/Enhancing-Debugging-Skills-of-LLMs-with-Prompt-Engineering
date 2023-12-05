The bug in the provided code is the addition of `i` result towards the output[i] in the first loop. We only need to add `i` once during the first loop and add the remaining `i` + (len - i - 1) to the output[i] during the second loop.

Fix:
```java
class Solution {
    public long[] getDistances(int[] arr) {
        long[] output = new long[arr.length];
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0L);
                countMap.put(arr[i], 0);
            }
            output[i] += i * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        sumMap.clear();
        countMap.clear();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0L);
                countMap.put(arr[i], 0);
            }
            output[i] += (len - i - 1) * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + (len - i - 1));
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        return output;
    }
}
```