class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeros.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    Integer next = zeros.ceiling(map.get(rains[i]));
                    if (next == null) return new int[0];
                    res[next] = rains[i];
                    zeros.add(next);
                }
                res[i] = - 1;
                map.put(rains[i], i);
            }
        }
        for (int i : zeros) res[i] = 1;
        return res;
    }
}