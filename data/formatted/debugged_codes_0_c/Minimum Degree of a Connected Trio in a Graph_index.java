Upon initial review of the code, it appears that the bug is in the condition `if (graph[i][j + 2])` inside the nested for loop. Let's go through the code step-by-step to verify and fix the bug:

1. The code initializes a 2D boolean array called `graph` with size `n+1`. This array is used to store edge information between nodes.
2. The code also initializes an integer array called `inDegree` with size `n+1`. This array is used to store the inDegrees of each node.
3. The outer for loop iterates from 1 to `n`.
4. The nested for loop iterates from `i+1` to `n`.
5. The if condition `if (graph[i][j + 2])` checks if `graph[i][j + 2]` is true. However, this is likely an incorrect indexing since `j + 2` may exceed the bounds of the array.
6. Inside the second nested for loop, there is another if condition `if (graph[i][k] && graph[j][k])` that checks if there is an edge between nodes `i`, `j`, and `k`.
7. If the condition is true, the code calculates the sum of in-degrees of nodes `i`, `j`, and `k` minus 6 and updates the `result`.
8. Finally, the code returns the `result` if it is not equal to `Integer.MAX_VALUE`, otherwise it returns -1.

To fix the bug, we need to correct the indexing in the if condition `if (graph[i][j + 2])`. Since we want to access the element at `graph[i][j]`, we should change the condition to `if (graph[i][j])`. 

Here's the corrected code:

```java
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        // to store edge information
        boolean[][] graph = new boolean[n + 1][n + 1];
        //to store inDegrees to a node(NOTE: here inDegree and outDegree are same because it is Undirected graph)
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;

            inDegree[edge[0]]