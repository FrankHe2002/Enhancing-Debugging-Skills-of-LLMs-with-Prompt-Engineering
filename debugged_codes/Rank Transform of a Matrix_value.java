// Runtime: 209 ms (Top 84.06%) | Memory: 75.7 MB (Top 97.21%)
class Solution {
    int[] parent;
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] answer = new int[m][n];

        // GROUP BY MATRIX VAL -> {X,Y}
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int[] xy = {i,j};
                int val = matrix[i][j];
                if(map.get(val) == null)
                    map.put(val, new ArrayList<>());
                map.get(val).add(xy);
            }
        }

        // INITIALIZE MIN-RANK ARRAY FOR EVERY COL/ROW
        int[] minX = new int[m];
        int[] minY = new int[n];

        for(Integer key : map.keySet()){
            List<int[]> list = map.get(key);

            // SPLIT TO GROUPS USING UNION FIND FOR VALs IN SAME COL/ROW
            int lSize = list.size();
            parent = new int[lSize];
            for(int i = 0; i < lSize; i++)
                parent[i] = i;

            // Group the xy by col and row then union by row & by col
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for(int i = 0; i < lSize; i++){
                int[] xy = list.get(i);
                int x = xy[0];
                int y = xy[1];

                if(xMap.get(x) == null)
                    xMap.put(x, new ArrayList<>());
                if(yMap.get(y) == null)
                    yMap.put(y, new ArrayList<>());
                xMap.get(x).add(i);
                yMap.get(y).add(i);
            }

            // union by X
            for(Integer xKey : xMap.keySet()){
                List<Integer> xList = xMap.get(xKey);
                for(int i = 1; i < xList.size(); i++){
                    union(xList.get(i-1), xList.get(i));
                }
            }

            // union by Y
            for(Integer yKey : yMap.keySet()){