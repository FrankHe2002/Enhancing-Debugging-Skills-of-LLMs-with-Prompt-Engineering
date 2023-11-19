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

    Set<Integer> computeDescendants(int src, int parent, Map<Integer, Set<Integer>> descendants, Map<Integer, List<Integer>> adjGraph) {

        Set<Integer> childrenOfNode = new HashSet<>();

        for (int child : adjGraph.get(src)) {
            if (child != parent) {
                childrenOfNode.add(child);
                childrenOfNode.addAll(computeDescendants(child, src, descendants, adjGraph));
            }
        }

        descendants.put(src, childrenOfNode);
        return childrenOfNode;
    }

    int computeNodeXorDfs(int src, int parent, int[] nums, Map<Integer, Integer> xorMap, Map<Integer, List<Integer>> adjGraph) {

        int srcXor = nums[src];

        for (int child : adjGraph.get(src)) {
            if (child != parent)
                srcXor ^= computeNodeXorDfs(child, src, nums, xorMap, adjGraph);
        }

        xorMap.put(src, srcXor);
        return srcXor;
    }

    Map<Integer, List<Integer>> computeAdjGraph(int[][] edges) {

        Map<Integer, List<Integer>> adjGraph = new HashMap<>();

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];

            if (! adjGraph.containsKey(v1)) {
                adjGraph.put(v1, new ArrayList<>());
            }

            if (! adjGraph.containsKey(v2)) {
                adjGraph.put(v2, new ArrayList<>());
            }
            adjGraph.get(v1).add(v2);
            adjGraph.get(v2).add(v1);
        }
        return adjGraph;
    }
}
