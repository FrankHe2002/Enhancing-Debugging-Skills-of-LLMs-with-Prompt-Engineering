The code has multiple issues to address:

1. The computeIfAbsent method in the for-loop is adding elements to the Set incorrectly.
2. The add operation is incorrectly adding the pair values.

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int checkWays(int[][] pairs) {
        int result = 1;
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] pair : pairs) {
            edges.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[1]);
            edges.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[0]);
        }
        List<Map.Entry<Integer, Set<Integer>>> edgesList = new ArrayList<>(edges.entrySet());
        edgesList.sort((a, b) -> b.getValue().size() - a.getValue().size());

        List<Map.Entry<Integer, Set<Integer>>> previous = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> cur : edgesList) {
            Set<Integer> currentSet = cur.getValue();
            Map.Entry<Integer, Set<Integer>> parent = find(previous, currentSet);
            if (parent == null) {
                if (currentSet.size() != edges.size())
                    return 0;
            } else {
                Set<Integer> parentSet = parent.getValue();
                if (!parentSet.containsAll(currentSet)) return 0;
                if (parentSet.equals(currentSet)) result = 2;
            }
            previous.add(cur);
        }
        return result;
    }

    Map.Entry<Integer, Set<Integer>> find(List<Map.Entry<Integer, Set<Integer>>> previous, Set<Integer> currentSet) {
        for (int i = previous.size() - 1; i >= 0; i--) {
            Map.Entry<Integer, Set<Integer>> entry = previous.get(i);
            if (currentSet.contains(entry.getKey())) return entry;
        }
        return null;
    }
}
```