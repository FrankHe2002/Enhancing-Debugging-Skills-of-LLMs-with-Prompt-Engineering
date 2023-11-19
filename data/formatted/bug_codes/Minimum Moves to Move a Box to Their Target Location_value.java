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

        public boolean equals(Object o) {
            State other = (State) o;
            return
                    this.personRow == other.personRow &&
                            this.personCol == other.personCol &&
                            this.boxRow == other.boxRow &&
                            this.boxCol == other.boxCol;
        }

        public int hashCode() {
            return personRow * 10_000 + personCol * 1_000 + boxRow * 100 + boxCol;
        }

        public String toString() {
            return "ShopKeeper:{row:" + personRow + ", col:" + personCol + "}" +
                    "Box:{row:" + boxRow + ", col:" + boxCol + "}";
        }

        public int compareTo(State other) {
            int minDistanceThis = this.boxPushes + distanceToTarget(this);
            int minDistanceOther = other.boxPushes + distanceToTarget(other);
            return Integer.compare(minDistanceThis, minDistanceOther);
        }

    }

    private int distanceToTarget(State state) {
        int yDiff = Math.abs(state.boxCol - targetCol);
        int xDiff = Math.abs(state.boxRow - targetRow);
        return yDiff + xDiff;
    }

    private boolean isSolutionState(State state) {
        return state.boxRow == targetRow && state.boxCol == targetCol;
    }

    private List<State> getNeighbors(State state) {

        int personRow = state.personRow;
        int personCol = state.personCol;
        int boxRow = state.boxRow;
        int boxCol = state.boxCol;

        List<State> states = new ArrayList<>();
        for (int[] dir : DIRS) {
            int rowMove = dir[0];
            int colMove = dir[1];
            int personRowNew = personRow + rowMove;
            int personColNew = personCol + colMove;
            if (! inBounds(personRowNew, personColNew) ||
                    isWall(personRowNew, personColNew)) {
                continue;
            }
            boolean willPushBox = personRowNew == boxRow && personColNew == boxCol;

            if (willPushBox) {
                int boxRowNew = boxRow + rowMove;
                int boxColNew = boxCol + colMove;
                if (inBounds(boxRowNew, boxColNew) &&
                        ! isWall(boxRowNew, boxColNew)) {
                    states.add(new State(personRowNew, personColNew, boxRowNew, boxColNew, state.boxPushes + 1));
                }
            } else {
                states.add(new State(personRowNew, personColNew, boxRow, boxCol, state.boxPushes));
            }
        }
        return states;

    }

    private boolean isWall(int row, int col) {
        char cell = grid[row][col];
        return cell == '#';
    }

    private boolean inBounds(int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1) {
            return false;
        }
        return true;
    }

    private State getInitialState() {

        int shopKeeperRow = 0;
        int shopKeeperCol = 0;

        int boxRow = 0;
        int boxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            char[] row = grid[r];
            for (int c = 0; c < row.length; c++) {
                char cell = grid[r][c];
                if (cell == 'T') {
                    this.targetRow = r;
                    this.targetCol = c;
                } else if (cell == 'B') {
                    boxRow = r;
                    boxCol = c;
                } else if (cell == 'S') {
                    shopKeeperRow = r;
                    shopKeeperCol = c;
                }
            }
        }

        return new State(shopKeeperRow, shopKeeperCol, boxRow, boxCol, 0);
    }

    public int minPushBox(char[][] grid) {
        this.grid = grid;

        State initialState = getInitialState();
        Queue<State> queue = new PriorityQueue<>();
        Set<State> visited = new HashSet<>();
        queue.offer(initialState);
        while (! queue.isEmpty()) {
            State state = queue.poll();
            if (visited.contains(state)) {
                continue;
            }
            visited.add(state);
            if (isSolutionState(state)) {
                return state.boxPushes;
            }
            for (State neighbor : getNeighbors(state)) {
                if (! visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
            ;
        }
        return - 1;
    }

}