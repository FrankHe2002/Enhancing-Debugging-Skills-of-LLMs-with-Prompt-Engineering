class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Queue<Integer>> iToPairs = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            iToPairs.computeIfAbsent(pair[0], k -> new ArrayDeque<>()).add(pair[1]);
            iToPairs.computeIfAbsent(pair[1], k -> new ArrayDeque<>()).add(pair[0]);
        }
        int start = - 1;
        for (int i : iToPairs.keySet()) {
            if (iToPairs.get(i).size() == 1) {
                start = i;
                break;
            }
        }
        int n = adjacentPairs.length + 1;
        int writeIdx = 0;
        int[] restored = new int[n];
        restored[writeIdx++] = start;
        while (writeIdx < n) {
            int next = iToPairs.get(start).remove();
            iToPairs.get(next).remove(start);
            restored[writeIdx++] = next;
            start = next;
        }

        return restored;
    }
}