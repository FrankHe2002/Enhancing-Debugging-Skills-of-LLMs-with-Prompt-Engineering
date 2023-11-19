Bug Type: Logic Error

Explanation:
Upon reviewing the code, it seems that the logic for computing the descendants of a node is incorrect. The code currently checks if a child node is equal to the parent node and adds it, along with its children, to the set of descendants. This logic is incorrect as the child node should not be included in the descendants set.

To fix this bug, we can modify the `computeDescendants` method to check if the child node is not equal to the parent node before adding it and its children to the set of descendants.

Here's the modified code:

```java
Set<Integer> computeDescendants(int src, int parent, Map<Integer, Set<Integer>> descendants, Map<Integer, List<Integer>> adjGraph) {
    Set<Integer> childrenOfNode = new HashSet<>();

    for (int child : adjGraph.get(src)) {
        if (child != parent) {
            // add all its children.
            childrenOfNode.addAll(computeDescendants(child, src, descendants, adjGraph));
        }
    }

    descendants.put(src, childrenOfNode);
    return childrenOfNode;
}
```

With this fix, the logic for computing the descendants of a node should be correct.