Buggy Code Explanation:
The buggy code has a logical error in the loop condition `i <= size`. Since `isCheck` is an array of size `size + 1`, the loop should only iterate up to the size of `isConnected`, not `size + 1`. 

Additionally, there is a missing import statement for the `Queue` and `LinkedList` classes.

Buggy Code Fix:
```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] isCheck = new boolean[size];
        int ans = 0;

        for (int i = 0; i < size; i++) {

            if (!isCheck[i]) { // Doing BFS if it's false in isCheck[]
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                ans++; // No. of queue = No. of Graphs

                while (!q.isEmpty()) {
                    int temp = q.remove();
                    isCheck[temp] = true;

                    for (int j = 0; j < size; j++) {
                        if (isConnected[temp][j] == 1 && !isCheck[j]) {
                            q.add(j);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
```

Fixed Code Explanation:
In the fixed code, the loop condition in the outer loop has been changed to `i < size`. Additionally, the missing import statements for `Queue` and `LinkedList` have been added. The code now correctly iterates over the `isConnected` array and performs breadth-first search (BFS) on each unvisited node.