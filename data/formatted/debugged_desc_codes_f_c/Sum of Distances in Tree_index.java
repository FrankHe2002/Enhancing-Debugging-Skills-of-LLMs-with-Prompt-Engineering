```java
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
            return new int[]{0};
        }

        int[] countSubNodes = new int[n];
        Arrays.fill(countSubNodes, 1);
        int[] distances = new int[n];
        Map<Integer, List<Integer>> graph = getGraph(edges);
        postOrderTraversal(0, -1, countSubNodes, distances, graph, new boolean[n]);
        preOrderTraversal(0, -1, countSubNodes, distances, graph, n, new boolean[n]);
        return distances;
    }

    private void postOrderTraversal(int node, int parent, int[] countSubNodes, int[] distances, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        List<Integer> children = graph.get(node);
        for (int child : children) {
            if (child != parent && !visited[child]) {
                postOrderTraversal(child, node, countSubNodes, distances, graph, visited);
                countSubNodes[node] += countSubNodes[child];
                distances[node] += distances[child] + countSubNodes[child];
            }
        }
    }

    private void preOrderTraversal(int node, int parent, int[] countSubNodes, int[] distances, Map<Integer, List<Integer>> graph, int n, boolean[] visited) {
        visited[node] = true;
        List<Integer> children = graph.get(node);
        for (int child : children) {
            if (child != parent && !visited[child]) {
                distances[child] = distances[node] + (n - countSubNodes[child]) - countSubNodes[child];
                preOrderTraversal(child, node, countSubNodes, distances, graph, n, visited);
            }
        }
    }
}
```