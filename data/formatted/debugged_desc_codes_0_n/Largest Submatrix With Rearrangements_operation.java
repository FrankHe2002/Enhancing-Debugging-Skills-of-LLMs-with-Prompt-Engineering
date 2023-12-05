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

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // minheap
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) pq.add(matrix[i][j]); // Add all the entries from row i in minheap
            }
            int size, curr;
            while (! pq.isEmpty()) {
                curr = pq.peek();
                size = curr * (pq.size() + 1);
                maxSize = Math.max(maxSize, size);
                pq.poll();
            }
        }
        return maxSize;
    }
}
```