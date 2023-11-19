import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] DIRECTION = new int[][] {{0, - 1}, {0, 1}, {- 1, 0}, {1, 0}};
    int rows;
    int cols;
    int[][] isWater;


    public int[][] highestPeak(int[][] isWater) {
        this.isWater = isWater;
        rows = isWater.length;
        cols = isWater[0].length;


        int[][] heightCells = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isWater[r][c] == 1) {
                    heightCells[r][c] = 0;
                    queue.add(new int[] {r, c});
                } else {
                    heightCells[r][c] = - 1;
                }
            }
        }
        bfs(queue, heightCells);


        return heightCells;
    }

    private void bfs(Queue<int[]> queue, int[][] heightCells) {

        while (! queue.isEmpty()) {
            int[] cell = queue.remove();
            for (int[] dir : DIRECTION) {

                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (! isInsideGrid(newRow, newCol)) continue;
                if (heightCells[newRow][newCol] != - 1) continue;
                heightCells[newRow][newCol] = heightCells[cell[0]][cell[1]] + 1;
                queue.add(new int[] {newRow, newCol});
            }

        }
    }

    private boolean isInsideGrid(int row, int col) {