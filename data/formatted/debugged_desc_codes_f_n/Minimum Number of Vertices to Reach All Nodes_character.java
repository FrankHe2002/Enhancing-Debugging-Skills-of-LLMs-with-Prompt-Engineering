```java
// Runtime: 17 ms (Top 90.40%) | Memory: 116.4 MB (Top 99.64%)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] indegree = new int[n];

        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
```