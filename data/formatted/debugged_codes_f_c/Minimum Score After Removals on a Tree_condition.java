Buggy Code Explanation:
The code has multiple issues. 

1. The `computeDescendants` method is not correctly computing the descendants of a node. It is adding the child node to the set `childrenOfNode` even if it is not the parent node. To fix this, the condition `if (child == parent)` should be changed to `if (child != parent)` so that only the child nodes are processed.

2. The `computeNodeXorDfs` method is not correctly computing the XOR of each node. It is not taking into account the XOR of the parent node. To fix this, the line `srcXor ^= computeNodeXorDfs(child, src, nums, xorMap, adjGraph);` should be changed to `srcXor ^= nums[child] ^ computeNodeXorDfs(child, src, nums, xorMap, adjGraph);`.

3. The loop indices in the nested loops are incorrect. The inner loop should start from `i` instead of `i + 1` to avoid redundant calculations.

4. There is a missing closing parenthesis in the condition `if (descendants.get(i).contains(j)`.

5. The variable `minScore` is not initialized correctly. It should be initialized with `Integer.MAX_VALUE` instead of `0`.

Fixed Code:
```java
class Solution {
    public int minimumScore(int[] nums, int[][] edges) {

        // 1.) Compute the adjacency table. Contains all paths, (including to root, must be filtered out later).
        Map<Integer, List<Integer>> adjGraph = computeAdjGraph(edges);

        // 2.) Now compute the total Xors of each node DFS style.
        Map<Integer, Integer> xorMap = new HashMap<>();
        computeNodeXorDfs(0, -1, nums, xorMap, adjGraph);
        int rootXor = xorMap.get(0);

        // 3.) Before computing all XORs in O(N^2) fashion, we want to compute a list of nodes of ascendant, descendant relationships.
        // Here we have to chose a SET instead of a list -> else we will run into TLS, obviously there are some duplicates.
        Map<Integer, Set<Integer>> descendants = new HashMap<>();
        Set<Integer> rootChildren = computeDescendants(0, -1, descendants, adjGraph);

        // 4.) We can check now the parent <-> child relationships. 
        // Compute each node under the root (