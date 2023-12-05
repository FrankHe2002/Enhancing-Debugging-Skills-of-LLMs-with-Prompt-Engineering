The bug type in the original code is a logical error, where the calculation of the sum is incorrect. This is causing the result to be incorrect. The main fix will be to correctly perform the addition of the updated values.

Fix:
```java
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : nums) minHeap.add(val);

        while (k > 0) {

            int curr = minHeap.poll();
            minHeap.add(-curr);
            k--;
        }

        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll(); // Change from sum %= minHeap.poll(); to sum += minHeap.poll();
        }
        return sum;
    }
}
```