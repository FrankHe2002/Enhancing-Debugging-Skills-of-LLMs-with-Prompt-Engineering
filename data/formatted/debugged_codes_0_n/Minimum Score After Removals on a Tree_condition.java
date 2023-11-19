```java
class Solution {
    public int minimumScore(int[] nums, int[][] edges) {

        Map<Integer, List<Integer>> adjGraph = computeAdjGraph(edges);

        Map<Integer, Integer> xorMap = new HashMap<>();
        computeNodeXorDfs(0, - 1, nums, xorMap, adjGraph);
        int rootXor = xorMap.get(0);

        Map<Integer, Set<Integer>> descendants = new HashMap<>();
        Set<Integer> rootChildren = computeDescendants(0, - 1, descendants, adjGraph);

        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < adjGraph.keySet().size(); i++) {
            for (int j = i + 1; j < adjGraph.keySet().size(); j++) {
                if (descendants.get(i).contains(j)) {
                    int rootXor1 = rootXor ^ xorMap.get(i);
                    int xor1 = xorMap.get(i) ^ xorMap.get(j);
                    int xor2 = xorMap.get(j);
                    int maxValue = Math.max(rootXor1, Math.max(xor1, xor2));
                    int minValue = Math.min(rootXor1, Math.min(xor1, xor2));
                    minScore = Math.min(minScore, maxValue - minValue);
                } else if (descendants.get(j).contains(i)) {
                    int rootXor1 = rootXor ^ xorMap.get(j);
                    int xor1 = xorMap.get(j) ^ xorMap.get(i);
                    int xor2 = xorMap.get(i);
                    int maxValue = Math.max(rootXor1, Math.max(xor1, xor2));
                    int minValue = Math.min(rootXor1, Math.min(xor1, xor2));
                    minScore = Math.min(minScore, maxValue - minValue);
                } else {
                    int rootXor1 = rootXor ^ (xorMap.get(i) ^ xorMap.get(j));
                    int xor1 = xorMap.get(i);
                    int xor2 = xorMap.get(j);
                    int maxValue = Math.max(rootXor1, Math.max(xor1, xor2));
                    int minValue = Math.min(rootXor1, Math.min(xor1, xor2));
                    minScore = Math.min(minScore, maxValue - minValue);
                }
            }
        }

        return minScore;
    }

    Set<Integer> computeDescendants(int src, int parent, Map<Integer, Set