```java
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        dfs(graph, 0, graph.length - 1, results, path, visited);
        
        return results;
    }

    public void dfs(int[][] graph, int current, int end, List<List<Integer>> results, List<Integer> path, boolean[] visited) {
        visited[current] = true;
        path.add(current);
        
        if (current == end) {
            results.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    dfs(graph, neighbor, end, results, path, visited);
                }
            }
        }

        visited[current] = false;
        path.remove(path.size() - 1);
    }
}
```