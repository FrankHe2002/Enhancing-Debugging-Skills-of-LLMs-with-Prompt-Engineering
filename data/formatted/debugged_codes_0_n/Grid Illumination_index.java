```java
import java.util.HashMap;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> d1 = new HashMap<>();
        HashMap<Integer, Integer> d2 = new HashMap<>();
        HashMap<Integer, Integer> cellno = new HashMap<>();

        for (int i = 0; i < lamps.length; i++) {
            int row1 = lamps[i][0];
            int col1 = lamps[i][1];
            row.put(row1, row.getOrDefault(row1, 0) + 1);
            col.put(col1, col.getOrDefault(col1, 0) + 1);
            d1.put((row1 + col1), d1.getOrDefault((row1 + col1), 0) + 1);
            d2.put((row1 - col1), d2.getOrDefault((row1 - col1), 0) + 1);
            int cell = row1 * n + col1;
            cellno.put(cell, cellno.getOrDefault(cell, 0) + 1);
        }

        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int cell = row1 * n + col1;
            ans[i] = (row.containsKey(row1) || col.containsKey(col1) || d1.containsKey(row1 + col1) || d2.containsKey(row1 - col1) || cellno.containsKey(cell)) ? 1 : 0;

            if (cellno.containsKey(cell)) {
                int val = cellno.get(cell);
                cellno.remove(cell);

                if (row.containsKey(row1)) {
                    int rowval = row.get(row1);
                    rowval -= val;
                    if (rowval == 0) {
                        row.remove(row1);
                    } else {
                        row.put(row1, rowval);
                    }
                }

                if (col.containsKey(col1)) {
                    int