class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = persons.length;
        int[] result = new int[n];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] flower : flowers) {
            treeMap.put(flower[0], treeMap.getOrDefault(flower[0], 0) + 1);
            treeMap.put(flower[1] + 1, treeMap.getOrDefault(flower[1] + 1, 0) - 1);
        }

        TreeMap<Integer, Integer> sum = new TreeMap<>();
        int prev = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            prev += entry.getValue();
            sum.put(entry.getKey(), prev);
        }

        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = sum.floorEntry(persons[i]);
            if (entry != null) result[i] = entry.getValue();
        }
        return result;
    }
}