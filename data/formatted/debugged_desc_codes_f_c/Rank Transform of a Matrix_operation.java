```java
// Fixed code
class Solution {
    int[] parent;

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] answer = new int[m][n];

        // GROUP BY MATRIX VAL -> {X,Y}
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] xy = {i, j};
                int val = matrix[i][j];
                if(map.containsKey(val))
                    map.get(val).add(xy);
                else{
                    List<int[]> list = new ArrayList<>();
                    list.add(xy);
                    map.put(val, list);
                }
            }
        }

        // INITIALIZE MIN-RANK ARRAY FOR EVERY COL/ROW
        int[] minX = new int[m];
        int[] minY = new int[n];

        for (Integer key : map.keySet()) {
            List<int[]> list = map.get(key);

            // SPLIT TO GROUPS USING UNION FIND FOR VALs IN SAME COL/ROW
            int lSize = list.size();
            parent = new int[lSize];
            for (int i = 0; i < lSize; i++)
                parent[i] = i;

            // Group the xy by col and row then union by row & by col
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for (int i = 0; i < lSize; i++) {
                int[] xy = list.get(i);
                int x = xy[0];
                int y = xy[1];

                xMap.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
                yMap.computeIfAbsent(y, k -> new ArrayList<>()).add(i);
            }

            // union by X
            for (List<Integer> xList : xMap.values()) {
                for (int i = 1; i < xList.size(); i++) {
                    union(xList.get(i - 1), xList.get(i));
                }
            }

            // union by Y
            for (List<Integer> yList : yMap.values()) {
                for (int i = 1; i < yList.size(); i++) {
                    union(yList.get(i - 1), yList.get(i));
                }
            }

            HashMap<Integer, List<int[]>> group = new HashMap<>();
            for (int i = 0; i < lSize; i++) {
                int grp = find(i);
                group.computeIfAbsent(grp, k -> new ArrayList<>()).add(list.get(i));
            }

            // SET ANSWER FOR EACH GROUP
            for (Integer grpKey : group.keySet()) {
                int max = 1;
                List<int[]> sublist = group.get(grpKey);

                // FIND MAX-RANK FOR THIS GROUP
                for (int[] xy : sublist) {
                    int x = xy[0];
                    int y = xy[1];

                    max = Math.max(max, Math.max(minX[x], minY[y]));
                }

                // UPDATE ANSWER = MAX-RANK AND SET NEW MIN-RANK FOR ROW/COL = MAX-RANK+1
                for (int[] xy : sublist) {
                    int x = xy[0];
                    int y = xy[1];
                    answer[x][y] = max;
                    minX[x] = max;
                    minY[y] = max;
                }
            }
        }
        return answer;
    }

    // UNION FIND IMPL
    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb){
            parent[pb] = pa;
        }
    }

    int find(int a) {
        int pa = parent[a];
        if (pa != a) {
            parent[a] = find(pa);
            return parent[a];
        }
        return pa;
    }
}
```