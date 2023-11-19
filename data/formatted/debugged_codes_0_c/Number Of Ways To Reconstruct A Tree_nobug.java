Bug: The bug in the given code is in the computation of the adjacency list. There is a mistake in the `computeIfAbsent()` calls for adding pairs to the adjacency list. 

In the current implementation, both `pair[0]` and `pair[1]` are being added to their respective sets. This is incorrect because `pair[0]` and `pair[1]` should be connected edges, not individual nodes. 

To fix this bug, we need to change the following lines:

```java
edges.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[0]);
edges.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[1]);
```

to:

```java
edges.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[1]);
edges.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[0]);
```

By making this change, we ensure that the pairs are correctly added to the adjacency list by connecting the nodes instead of treating them as individual nodes.

Fixed code:

```java
class Solution {
    public int checkWays(int[][] pairs) {
        int result = 1;

        // Create adjacency list
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] pair : pairs) {
            edges.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[1]);
            edges.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[0]);
        }

        // Sort the edge lists based on their size
        List<Map.Entry<Integer, Set<Integer>>> edgesList = new ArrayList<>(edges.entrySet());
        Collections.sort(edgesList, (a, b) -> b.getValue().size() - a.getValue().size());

        List<Map.Entry<Integer, Set<Integer>>> previous = new ArrayList<>();

        // Now from each of the edges find the ways to create the tree
        for (Map.Entry<Integer, Set<Integer>> cur : edgesList) {
            // Get the current edge set
            Set<Integer> currentSet = cur.getValue();
            // Find the parent for the current set from the previously computed edge
            Map.Entry<Integer, Set<Integer>> parent = find(previous, currentSet);
            // If the parent is null
            if (parent == null) {
                // If the current set do not match with the edges size then there is no way, return 0
                if (currentSet.size()