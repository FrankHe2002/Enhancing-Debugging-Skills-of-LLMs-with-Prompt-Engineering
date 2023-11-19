```java
import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        Map<Integer, Map<Integer, Integer>> dupMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] ans = new int[queries.length];
        int[] count = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int min = Math.min(edges[i][0] - 1, edges[i][1] - 1);
            int max = Math.max(edges[i][0] - 1, edges[i][1] - 1);
            dupMap.computeIfAbsent(min, o -> new HashMap<>()).merge(max, 1, Integer::sum);
            map.computeIfAbsent(min, o -> new HashSet<>()).add(max);
            count[min]++;
            count[max]++;
        }
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(o -> count[o]));
        for (int j = 0, hi = n; j < queries.length; j++, hi = n) {
            for (int i = 0; i < n; i++) {
                while (hi > i + 1 && count[indexes[i]] + count[indexes[hi - 1]] > queries[j]) {
                    hi--;
                }
                if (hi == i) {
                    hi++;
                }
                ans[j] += n - hi;
                for (int adj : map.getOrDefault(indexes[i], Collections.emptySet())) {
                    int ttl = count[indexes[i]] + count[adj];
                    if (ttl > queries[j] && ttl - dupMap.get(indexes[i]).get(adj) <= queries[j]) {
                        ans[j]--;
                    }
                }
            }
        }
        return ans;
    }
}
```