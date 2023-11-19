```java
class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //we take 5 hashmap
        //1st hashmap for row
        HashMap<Integer, Integer> row = new HashMap<>();
        //2nd hashmap for column
        HashMap<Integer, Integer> col = new HashMap<>();
        //3rd hashmap for lower diagonal
        HashMap<Integer, Integer> d1 = new HashMap<>();
        //4th diagonal for upper diagonal
        HashMap<Integer, Integer> d2 = new HashMap<>();
        //5th diagonal for cell no meaning lamp is present at this spot
        HashMap<Integer, Integer> cellno = new HashMap<>();

        for (int i = 0; i < lamps.length; i++) {
            //get row and column from lamps array
            int row1 = lamps[i][0];
            int col1 = lamps[i][1];
            //place row in row hashmap
            row.put(row1, row.getOrDefault(row1, 0) + 1);
            //place column in col hashmap
            col.put(col1, col.getOrDefault(col1, 0) + 1);
            //place d1 dia in d1
            d1.put((row1 + col1), d1.getOrDefault((row1 + col1), 0) + 1);
            //place d2 diagonal
            d2.put((row1 - col1), d2.getOrDefault((row1 - col1), 0) + 1);
            //place cellno in cell no hashmap
            int cell = row1 * n + col1;
            cellno.put(cell, cellno.getOrDefault(cell, 0) + 1);
        }
        //direction array which travels in 8 adjacent direction
        int[][] dir = {{- 1, 0}, {- 1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, - 1}, {0, - 1}, {- 1, - 1}};
        int[] ans = new int[queries.length];
        //process all queries
        for (int i = 0; i < queries.length; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int cell = row1 * n + col1;
            ans[i] = (row.containsKey(row1) || col