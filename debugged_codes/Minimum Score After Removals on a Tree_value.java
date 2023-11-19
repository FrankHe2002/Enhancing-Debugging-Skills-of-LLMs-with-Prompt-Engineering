import java.util.*;

class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        // 1.) Compute the adjacency table. Contains all paths, (including to root, must be filtered out later).
        Map<Integer, List<Integer>> adjGraph = computeAdjGraph(edges);
        
        // 2.) Know compute the total Xors of each node DFS style.
        Map<Integer, Integer> xorMap = new HashMap<>();
        computeNodeXorDfs(0, -1, nums, xorMap, adjGraph);
        int rootXor = xorMap.get(0);
        
        // 3.) Before computing all XORs in O(N^2) fashion, we want to compute a list of nodes of ascendant, descendant relationships.
        // Here we have to chose a SET instead of a list -> else we will run into TLS, obviously there are some duplicates.
        Map<Integer, Set<Integer>> descendants = new HashMap<>();
        Set<Integer> rootChildren = computeDescendants(0, -1, descendants, adjGraph);
        
        // 4.) We can check now the parent <-> child relationships. 
        // Compute each node under the root (not the root itself) for the following conditions:
        // node_i is parent of node_j
        // rootXor = total ^ node_i (removing node_i from total)
        // xor1 = node_i^ node_j (removing node_j from node_i)
        // xor2 = node_j
        // node_j is parent of node_i
        // rootXor = total ^ node_j (removing node_j from total)
        // xor1 = node_j^ node_i (removing node_i from node_j)
        // xor2 = node_i
        // node_j & node_i belong to different parents.
        // rootXor = total ^ node_j^ nodE_i (removing node_i & node_j from total)
        // xor1 = node_i
        // xor2 = node_j
        
        int minScore = Integer.MAX_VALUE;
        
        for(int i = 1; i < adjGraph.keySet().size(); i++){
            for(int j = i+1; j < adjGraph.keySet().size(); j++){
                // Is node_i parent of node_j
                if(descendants.get(i).contains(j)){
                    int rootXor1 =  rootXor ^ xorMap.get(i);