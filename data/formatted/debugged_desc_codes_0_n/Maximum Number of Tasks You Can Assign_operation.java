```java
import java.util.Arrays;
import java.util.TreeMap;

class Solution {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int st = 0;
        int end = Math.min(tasks.length, workers.length) - 1;
        int ans = 0;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (isPossibleToComplete(tasks, workers, pills, strength, mid)) {
                st = mid + 1;
                ans = Math.max(ans, mid + 1);
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    boolean isPossibleToComplete(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int n = workers.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = n - 1, count = 0; count <= mid && i >= 0; i--, count++) {
            map.merge(workers[i], 1, (a, b) -> a + b);
        }
        int done = n - 1;
        int count = mid;
        for (int i = mid; i >= 0; i--) {
            int val = tasks[i];
            Integer kv = map.ceilingKey(val);
            if (kv != null && map.get(kv) > 0) {
                map.put(kv, map.get(kv) - 1);
            } else {
                if (pills > 0 && kv != null && kv >= val - strength) {
                    pills--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```