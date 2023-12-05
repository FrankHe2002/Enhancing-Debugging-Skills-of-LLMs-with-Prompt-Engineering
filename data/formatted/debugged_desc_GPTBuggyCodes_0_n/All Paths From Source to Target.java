```java
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        helper(graph, 0, graph.length - 1, ans, temp, vis);

        return ans;
    }

    public void helper(int[][] graph, int src, int dest, List<List<Integer>> ans, List<Integer> temp, boolean[] vis) {
        vis[src] = true;
        temp.add(src);
        if (src == dest) {
            List<Integer> b = new ArrayList<>(temp);
            ans.add(b);
        } else {
            for (int i : graph[src]) {
                if (!vis[i]) {
                    helper(graph, i, dest, ans, temp, vis);
                }
            }
        }
        vis[src] = false;
        temp.remove(temp.size() - 1);
    }
}
```