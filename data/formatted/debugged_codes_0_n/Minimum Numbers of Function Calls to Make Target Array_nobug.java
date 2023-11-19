```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        int odd = 0, even = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int res = dfs(n, map);
            odd += res / 32;
            even = Math.max(res % 32, even);
        }

        return odd + even;
    }

    private int dfs(int n, Map<Integer, Integer> map) {
        if (n == 0) return 0;
        if (map.containsKey(n)) return map.get(n);

        int res = n % 2 * 32;
        res += dfs(n / 2, map) + (n > 1 ? 1 : 0);

        map.put(n, res);
        return res;
    }
}
```