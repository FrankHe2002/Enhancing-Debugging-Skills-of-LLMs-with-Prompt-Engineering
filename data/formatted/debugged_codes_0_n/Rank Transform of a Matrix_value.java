class Solution {
    int[] parent;

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] answer = new int[m][n];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] xy = {i, j};
                int val = matrix[i][j];
                if (map.get(val) == null)
                    map.put(val, new ArrayList<>());
                map.get(val).add(xy);
            }
        }
        int[] minX = new int[m];
        int[] minY = new int[n];

        for (Integer key : map.keySet()) {
            List<int[]> list = map.get(key);
            int lSize = list.size();
            parent = new int[lSize];
            for (int i = 0; i < lSize; i++)
                parent[i] = i;
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for (int i = 0; i < lSize; i++) {
                int[] xy = list.get(i);
                int x = xy[0];
                int y = xy[1];

                if (xMap.get(x) == null)
                    xMap.put(x, new ArrayList<>());
                if (yMap.get(y) == null)
                    yMap.put(y, new ArrayList<>());
                xMap.get(x).add(i);
                yMap.get(y).add(i);
            }
            for (Integer xKey : xMap.keySet()) {
                List<Integer> xList = xMap.get(xKey);
                for (int i = 1; i < xList.size(); i++) {
                    union(xList.get(i - 1), xList.get(i));
                }
            }
            for (Integer yKey : yMap.keySet()) {