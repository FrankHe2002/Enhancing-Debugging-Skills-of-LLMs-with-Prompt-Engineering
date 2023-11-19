**Bug Type:** Logical Error

**Bug Description:** The bug in the provided Java code is a logical error. The error occurs when calculating the distances in the `getDistances` method. The code contains two for loops to iterate over the `arr` array. In each iteration, it checks if the map `sumMap` contains the current value of `arr[i]`. If the value is not present in the map, it initializes it to 0 using `sumMap.put(arr[i], 0l)`. However, the bug is that it should initialize the value to `arr[i]` instead of 0. 

This means that every time a new value is encountered in the array `arr`, it is wrongly assumed that it has already appeared before with a count of 0. This leads to incorrect calculation of the distances.

**Fix:** To fix the bug, we need to change the line `sumMap.put(arr[i], 0l)` to `sumMap.put(arr[i], (long) arr[i])` in both the for loops. This will correctly initialize the value in the map `sumMap` to the current value of `arr[i]` instead of 0.

**Fixed Code:**
```java
class Solution {
    public long[] getDistances(int[] arr) {
        long[] output = new long[arr.length];
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; ++ i) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], (long) arr[i]);
                countMap.put(arr[i], 0);
            }

            output[i] += i * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        sumMap = new HashMap<>();
        countMap = new HashMap<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; -- i) {
            if (! sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], (long) arr[i]);
                countMap.put(arr[i], 0);
            }

            output[i] += (len - i - 1) + (long) countMap.get(arr[i])