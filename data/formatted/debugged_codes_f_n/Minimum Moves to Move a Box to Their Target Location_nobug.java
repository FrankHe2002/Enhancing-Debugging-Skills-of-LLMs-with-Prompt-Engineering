```java
// Runtime: 51 ms (Top 51.89%) | Memory: 54.4 MB (Top 47.17%)

/**
 * Finds Initial State (State consists of shopkeeper & box locations + # of boxMoves)
 * Uses BFS/A* Algorithm to visit valid transition states
 * Note: The min heuristic here is # of boxMoves + manHattanDistance between box & target locations
 */
class Solution {
    private int targetRow;
    private int targetCol;
    private char[][] grid;
    private static int[][] DIRS = {
            {1, 0}, //Down
            {- 1, 0},//Up
            {0, 1}, //Right
            {0, - 1} //Left
    };

    /**
     * State holds shopkeeper and box location, as well as how many times the box has been pushed
     */
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

        // Override equals - used along with hashcode when we have visited HashSet
        public boolean equals(Object o) {
            State other = (State) o;
            return
                    this.personRow == other.personRow &&
                            this.personCol == other.personCol &&
                            this.boxRow == other.boxRow &&
                            this.boxCol == other.boxCol;
        }

        // Override the hashCode - Note: it's okay for this to have collisions
        // But it won't due to the problem constraint that there is a bound on NxM dimensions
        public int hashCode() {
            return personRow * 10_000 + personCol * 1_000 + boxRow * 100 + boxCol;
        }

        // Override to string method - helpful in debugging state.
        public String toString() {
            return "ShopKeeper:{row:" + personRow + ", col:" + personCol + "}" +
                    "Box:{row:" + boxRow + ", col:" + boxCol + "}";
        }

        // Implement comparable interface such that we return the state that
       