// Runtime: 44 ms (Top 81.42%) | Memory: 99.3 MB (Top 65.13%)
class Solution {
    public int longestCycle(int[] edges) {
        int[] map = new int[edges.length];
        int result = -1;

        for (int i = 0; i < edges.length; i++)
            result = Math.max(result, helper(i, 1, edges, map));

        return result;
    }

    int helper(int index, int total, int[] edges, int[] map) {
        if (index == -1 || map[2] == -1)
            return -1;

        if (map[2] != 0)
            return total - map[2];

        map[2] = total;
        int result = helper(edges[2], total + 1, edges, map);
        map[2] = -1;

        return result;
    }
}