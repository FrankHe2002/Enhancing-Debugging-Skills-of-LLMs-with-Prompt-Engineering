Bug Type: Logic error

Bug Explanation: The bug lies in the `postOrderTraversal` method. In this method, when calculating `countSubNodes[node]`, the formula `countSubNodes[node] += countSubNodes[child - 1];` is used. However, this formula is incorrect because it assumes that the node values start from 1, whereas they actually start from 0 (as indicated by the `node` variable). This leads to incorrect calculations for `countSubNodes`.

Fix: To fix the bug, we need to adjust the formula `countSubNodes[node] += countSubNodes[child - 1];` to `countSubNodes[node] += countSubNodes[child];` so that we correctly update the value of `countSubNodes[node]`.

Fixed Code:
```java
import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new LinkedList<>());
            graph.putIfAbsent(edge[1], new LinkedList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n < 2 || edges == null) {
            return new int[] {0};
        }

        int[] countSubNodes = new int[n];
        Arrays.fill(countSubNodes, 1);
        int[] distances = new int[n];
        Map<Integer, List<Integer>> graph = getGraph(edges);
        postOrderTraversal(0, -1, countSubNodes, distances, graph);
        preOrderTraversal(0, -1, countSubNodes, distances, graph, n);
        return distances;
    }

    private void postOrderTraversal(int node, int parent, int[] countSubNodes, int[] distances, Map<Integer, List<Integer>> graph) {
        List<Integer> children = graph.get(node);
        for (int child : children) {
            if (child != parent) {
                postOrderTraversal(child, node, countSubNodes, distances, graph);
                countSubNodes[node] += countSubNodes[child];
                distances[node] += distances[child] + countSubNodes[child];
            }
        }
    }

    private void preOrderTraversal(int node, int parent