The bug in the provided code is in the while loop condition: `k < 0`. The loop should continue as long as `k` is greater than or equal to 0, not less than 0. 

To fix the bug, we need to change `k < 0` to `k >= 0` in the while loop condition. 

Here is the revised code with the bug fix:

```java
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : arr) freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(freqMap.get(i1), freqMap.get(i2)));
        pq.addAll(freqMap.keySet());
        while (k >= 0 && ! pq.isEmpty()) { // Fixed bug: changed k < 0 to k >= 0
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