The bug in the provided code is in the line `size = curr - pq.size();`. The intention seems to be to calculate the size of the current square by subtracting the number of entries greater than or equal to the current value from the value itself. However, `pq.size()` does not give the count of entries greater than or equal to the current value. Instead, it gives the total number of entries in the priority queue.

To fix this bug, we need to count the number of entries in the priority queue that are greater than or equal to the current value. We can do this by introducing a counter variable and incrementing it each time we add an entry to the priority queue. Then, we can calculate the size of the current square as `size = curr * counter`.

Fixed code:
```java
import java.util.PriorityQueue;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) continue;
                else matrix[i][j] = matrix[i - 1][j] + 1;
            }
        }

        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) pq.add(matrix[i][j]);
            }
            
            int size = 0, curr = 0, counter = 0;
            while (!pq.isEmpty()) {
                curr = pq.peek();
                counter++;
                size = curr * counter;
                maxSize = Math.max(maxSize, size);
                pq.poll();
            }
        }
        return maxSize;
    }
}
```