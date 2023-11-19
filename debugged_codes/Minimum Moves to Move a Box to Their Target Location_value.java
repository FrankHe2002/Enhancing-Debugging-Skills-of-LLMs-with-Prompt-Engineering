// Runtime: 51 ms (Top 51.89%) | Memory: 54.4 MB (Top 47.17%)
/**
  Finds Initial State (State consists of shopkeeper & box locations + # of boxMoves)
  Uses BFS/A* Algorithm to visit valid transition states
  Note: The min heuristic here is # of boxMoves + manHattanDistance between box & target locations
*/
class Solution {
    private int targetRow;
    private int targetCol;
    private char[][] grid;
    private static int[][] DIRS = {
            {1,0}, //Down
            {-1,0},//Up
            {0,1}, //Right
            {0,-1} //Left
    };

    /**
      State holds shopkeeper and box location, as well as how many times the box has been pushed
    */
    class State implements Comparable<State>{
        int personRow;
        int personCol;
        int boxRow;
        int boxCol;
        int boxPushes;

        public State(int personRow, int personCol, int boxRow, int boxCol, int boxPushes){
            this.personRow = personRow;
            this.personCol = personCol;
            this.boxRow = boxRow;
            this.boxCol = boxCol;
            this.boxPushes = boxPushes;
        }
        .
        .
        .