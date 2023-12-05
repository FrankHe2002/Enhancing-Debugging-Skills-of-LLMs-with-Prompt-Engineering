```java
class Solution {
    int[] res;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        res = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        postOrderDfs(adjList, labels, 0, -1);
        return res;
    }

    int[] postOrderDfs(Map<Integer, List<Integer>> adjList, String labels, int n, int parent) {
        int[] chars = new int[26];
        chars[labels.charAt(n) - 'a']++;
        for (int next : adjList.get(n)) {
            if (next != parent) {
                int[] childCount = postOrderDfs(adjList, labels, next, n);
                for (int i = 0; i < 26; i++) {
                    chars[i] += childCount[i];
                }
            }
        }
        res[n] = chars[labels.charAt(n) - 'a'];
        return chars;
    }
}
```