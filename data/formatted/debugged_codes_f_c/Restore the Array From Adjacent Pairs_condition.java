The bug in the provided code is in the `while` loop condition `writeIdx > n`. 

The loop is intended to continue until `writeIdx` becomes equal to `n`. However, the current condition `writeIdx > n` will always evaluate to `false` because `writeIdx` is initially set to `0` and `n` is the size of the map `iToPairs`, which is the number of adjacent pairs plus one. 

To fix this bug, the condition should be changed to `writeIdx < n`, ensuring that the loop continues until `writeIdx` reaches the value of `n`.

Fixed Code:
```java
// Runtime: 122 ms (Top 96.49%) | Memory: 87.3 MB (Top 95.99%)

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Build an adjacency list graph.
        Map<Integer, Queue<Integer>> iToPairs = new HashMap<>();
      
        for (int[] pair : adjacentPairs) {
            iToPairs.computeIfAbsent(pair[0], k -> new ArrayDeque<>()).add(pair[1]);
            iToPairs.computeIfAbsent(pair[1], k -> new ArrayDeque<>()).add(pair[0]);
        }

        // Find an item that has only one neighbour.
        int start = -1;
      
        for (int i : iToPairs.keySet()) {
            if (iToPairs.get(i).size() == 1) {
                start = i;
                break;
            }
        }

        // Traverse the graph in a linked-list fashion.
        int n = iToPairs.size();
        int writeIdx = 0;
        int[] restored = new int[n];
        restored[writeIdx++] = start;
      
        while (writeIdx < n) {
            int next = iToPairs.get(start).remove();
            iToPairs.remove(start);
            iToPairs.get(next).remove(start); // Remove the loop back to the current start.
            restored[writeIdx++] = next;
            start = next;
        }

        return restored;
    }
}
```