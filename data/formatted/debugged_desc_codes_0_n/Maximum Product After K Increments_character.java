```java
class Solution {
    public int maximumProduct(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // fix: reverseOrder added
        for (int num : nums) pq.add(num);

        while (k-- > 0) {
            int top = pq.poll() + 1;
            pq.add(top);
        }

        long res = 1;
        while (!pq.isEmpty()) { // fix: added missing parentheses
            res = (res * pq.poll()) % 1000000007;
        }

        return (int) (res);
    }
}
```