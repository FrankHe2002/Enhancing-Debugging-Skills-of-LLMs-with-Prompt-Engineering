* Bug type: Logical error and Off-by-one error

### Reasoning:
1. The `postOrderTraversal` method is used to calculate the count of sub-nodes and the distances from each node to all other nodes in the tree. There is an issue in the calculation of `countSubNodes` and `distances` in this method.
2. In the `postOrderTraversal` method, the `countSubNodes` should be incremented by the count of sub-nodes of the child, and the `distances` should be incremented by the distances of the child, along with the count of sub-nodes of the child.
3. The issue lies with the indexing of the child in calculating sub-nodes and distances.

### Bug Fix:
```java
private void postOrderTraversal(int node, int parent, int[] countSubNodes, int[] distances, Map<Integer, List<Integer>> graph) {
    List<Integer> children = graph.get(node);
    for (int child : children) {
        if (child != parent) {
            postOrderTraversal(child, node, countSubNodes, distances, graph);
            countSubNodes[node] += countSubNodes[child]; // Fix index
            distances[node] += distances[child] + countSubNodes[child]; // Fix index
        }
    }
}
```

After fixing the issue with the indexing in the `postOrderTraversal` method, the logic will correctly calculate the count of sub-nodes and the distances from each node to all other nodes in the tree.