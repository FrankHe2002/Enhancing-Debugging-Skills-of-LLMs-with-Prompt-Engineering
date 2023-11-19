```java
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<Pair<Double, Double>, Map<Double, List<int[][]>>> map = new HashMap<>();

        double res = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j]; // Fixed bug: added missing semicolon

                Pair<Double, Double> pm = new Pair<>((p1[0] + p2[0]) / 2d, (p1[1] + p2[1]) / 2d);
                if (!map.containsKey(pm))
                    map.put(pm, new HashMap<>());
                
                double dist2 = dist2(p1, p2);
                if (!map.get(pm).containsKey(dist2))
                    map.get(pm).put(dist2, new ArrayList<>());

                for (int[][] ps : map.get(pm).get(dist2)) {
                    double d1 = dist2(p1, ps[0]);
                    double d2 = dist2(p1, ps[1]);
                    res = Math.min(res, Math.sqrt(d1 * d2));
                }
                map.get(pm).get(dist2).add(new int[][] {p1, p2});
            }
        }

        return res == Double.MAX_VALUE ? 0 : res;
    }

    private double dist2(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
```