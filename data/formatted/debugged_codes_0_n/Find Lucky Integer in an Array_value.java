class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = - 1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int temp = - 1;
            if (e.getKey().equals(e.getValue())) {
                temp = e.getKey();
            }
            if (max < temp) {
                max = temp;
            }
        }
        if (max != - 1) return max;
        return - 1;
    }
}