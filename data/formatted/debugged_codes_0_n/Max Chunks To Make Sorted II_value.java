```java
class Solution {

    public int maxChunksToSorted(int[] arr) {

        // 1. Generate Right min

        int[] min_from_right = new int[arr.length + 1];
        min_from_right[arr.length] = Integer.MAX_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            min_from_right[i] = Math.min(arr[i], min_from_right[i + 1]);
        }

        // 2. Generate Left Max and Count chunks
        int chunk_count = 0;
        int max_cur = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max_cur = Math.max(max_cur, arr[i]);
            if (max_cur <= min_from_right[i + 1]) {
                chunk_count++;
            }
        }

        return chunk_count;
    }
}
```