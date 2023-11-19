class Solution {
    public int minChanges(int[] nums, int k) {
        int v = 1 << 10;
        int[] best = new int[v];
        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> n2c = new HashMap<Integer, Integer>();
            for (int p = i; p < nums.length; p += k) {
                n2c.put(nums[p], 1 + n2c.getOrDefault(nums[p], 0));
            }
            if (i == 0) {
                for (int vv : n2c.keySet()) {
                    best[vv] = n2c.get(vv);
                }
                continue;
            }
            int[] next = new int[v];
            int max = 0;
            for (int j : best) max = Math.max(max, j);
            for (int j = 0; j < v; j++) next[j] = max;
            for (int vv : n2c.keySet()) {
                int cnt = n2c.get(vv);
                for (int j = 0; j < v; j++) {
                    next[j ^ vv] = Math.max(next[j ^ vv], best[j] + cnt);
                }
            }
            best = next;
        }
        return nums.length - best[0];
    }
}