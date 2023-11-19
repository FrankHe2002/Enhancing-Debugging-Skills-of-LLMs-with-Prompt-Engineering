import java.util.*;

class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        Map<Integer, List<Integer>> adjGraph = computeAdjGraph(edges);
        Map<Integer, Integer> xorMap = new HashMap<>();
        computeNodeXorDfs(0, - 1, nums, xorMap, adjGraph);
        int rootXor = xorMap.get(0);
        Map<Integer, Set<Integer>> descendants = new HashMap<>();
        Set<Integer> rootChildren = computeDescendants(0, - 1, descendants, adjGraph);

        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < adjGraph.keySet().size(); i++) {
            for (int j = i + 1; j < adjGraph.keySet().size(); j++) {
                if (descendants.get(i).contains(j)) {
                    int rootXor1 = rootXor ^ xorMap.get(i);