// Runtime: 81 ms | Memory: 54.3 MB
class Solution {
    private Set<Integer>[] graph;
    private int[] indegrees;
    private int[][] ranges;
    private boolean[] exists;
    private int m;
    private int n;
    private int maxColor = 60;
    
    public boolean isPrintable(int[][] targetGrid) {
        this.m = targetGrid.length;
        this.n = targetGrid[0].length;
        buildRanges(targetGrid);
        buildGraph(targetGrid);
        int count = 0;
        int totalCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= maxColor; i++) {
            if (exists[i]) {
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
                totalCount++;
            }
        }
        while (!queue.isEmpty()) {
            count++;
            Integer current = queue.poll();
            for (Integer neighbor: graph[current]) {
                if (--indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == totalCount;
    }
    
    private void buildRanges(int[][] targetGrid) {
        this.ranges = new int[maxColor + 1][4];
        for (int i = 1; i <= maxColor; i++) {
            ranges[i][0] = ranges[i][1] = Integer.MAX_VALUE;
            ranges[i][2] = ranges[i][3] = Integer.MIN_VALUE;
        }
        exists = new boolean[maxColor + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                exists[color] = true;
                max = Math.max(max, color);
                ranges[color][0] = Math.min(ranges[color][0], j);
                ranges[color][1] = Math.min(ranges[color][1], i);
                ranges[color][2] = Math.max(ranges[color][2], j);
                ranges[color][3] = Math.max(ranges[color][3], i);
            }
        }
        maxColor = max;
    }
    
    private void buildGraph(int[][] targetGrid) {
        graph = new Set[maxColor + 1];