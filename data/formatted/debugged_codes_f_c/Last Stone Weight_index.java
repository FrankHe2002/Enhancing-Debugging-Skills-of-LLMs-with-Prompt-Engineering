Bug type: Array Index Out of Bounds

Reasoning: In the provided code, the loop condition `i < stones.length` correctly ensures that the loop iterates within the array's valid range. However, the line `pq.add(stones[-1])` attempts to access the element at index `-1`, which is out of bounds for the array. This causes an `ArrayIndexOutOfBoundsException`. 

Fix: Change `pq.add(stones[-1])` to `pq.add(stones[i])` to add the current element, `stones[i]`, to the priority queue.

Fixed code:
```java
// Runtime: 3 ms (Top 42.30%) | Memory: 40.7 MB (Top 84.83%)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int r1 = pq.poll();
            int r2 = pq.poll();
            if (r1 != r2) pq.add(r1 - r2);
        }
        return (pq.isEmpty()) ? 0 : pq.poll();
    }
}
```