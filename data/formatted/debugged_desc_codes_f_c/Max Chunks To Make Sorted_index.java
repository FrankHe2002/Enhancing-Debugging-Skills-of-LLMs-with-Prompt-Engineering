---

The given Java code contains the following bug:

1. The loop index used to compare with the running maximum is using `arr[1]` instead of `arr[i]`, which is incorrect.

Corrected code:

```java
class Solution {
    public int maxChunksToSorted(int[] arr) {

        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (i == max) count++;
        }
        return count;
    }
}
```