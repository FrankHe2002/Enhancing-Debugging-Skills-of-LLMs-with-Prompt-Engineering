```java
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Generating Map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e[] : prerequisites) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
        }

        List<Boolean> list = new ArrayList<>();
        // Appling DFS for every query to get result
        for (int[] q : queries) {
            list.add(isPre(q[0], q[1], graph, new HashSet<>()));
        }
        return list;
    }

    // Check if src comes before dst using DFS
    private boolean isPre(int src, int dst, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(src)) return false;
        visited.add(src);
        if(!adj.containsKey(src)){
            visited.remove(src);
            return false;
        }
        for (int neigh : adj.get(src)) {
            if (neigh == dst || isPre(neigh, dst, adj, visited)){
                visited.remove(src);
                return true;
            }
        }
        visited.remove(src);
        return false;
    }
}
```