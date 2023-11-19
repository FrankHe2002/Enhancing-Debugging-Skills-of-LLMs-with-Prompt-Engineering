class Solution {
    private int targetRow;
    private int targetCol;
    private char[][] grid;
    private static int[][] DIRS = {
            {1, 0},
            {- 1, 0},
            {0, 1},
            {0, - 1}
    };

    class State implements Comparable<State> {
        int personRow;
        int personCol;
        int boxRow;
        int boxCol;
        int boxPushes;

        public State(int personRow, int personCol, int boxRow, int boxCol, int boxPushes) {
            this.personRow = personRow;
            this.personCol = personCol;
            this.boxRow = boxRow;
            this.boxCol = boxCol;
            this.boxPushes = boxPushes;
        }
        .
                .
                .