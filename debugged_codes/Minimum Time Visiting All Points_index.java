// Runtime: 2 ms (Top 57.50%) | Memory: 43.4 MB (Top 57.64%)
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int max = 0;
        for(int i = 0; i < points.length - 1; i++){
            int x = Math.abs(points[i][0] - points[i+1][0]);
            int y = Math.abs(points[i][1] - points[i+1][1]);
            max += Math.max(x,y);
        }
        return max;
    }
}