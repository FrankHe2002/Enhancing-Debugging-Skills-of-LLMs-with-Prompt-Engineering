// Runtime: 10 ms (Top 92.68%) | Memory: 57 MB (Top 98.99%)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] indegree = new int[n];

        for(List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n;i ++) {
            if(indegree[i]==0)
                result.add(i);
        }

        return result;
    }
}