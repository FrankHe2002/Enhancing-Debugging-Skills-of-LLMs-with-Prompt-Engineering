The bug in the code seems to be in the while loop condition. The loop should continue as long as k is greater than 0 but the condition is checking if k is less than 0, which will never be true and will result in an infinite loop.

The fix will be to change the condition from `while (k < 0 && ! pq.isEmpty())` to `while (k > 0 && ! pq.isEmpty())`.

Here is the corrected code:

```java
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : arr) freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(freqMap.get(i1), freqMap.get(i2)));
        pq.addAll(freqMap.keySet());
        while (k > 0 && ! pq.isEmpty()) {
            int element = pq.poll();
            int toBeDeleted = Math.min(k, freqMap.get(element));
            k -= toBeDeleted;
            if (toBeDeleted < freqMap.get(element))
                pq.add(element);
        }
        return pq.size();
    }
}
```