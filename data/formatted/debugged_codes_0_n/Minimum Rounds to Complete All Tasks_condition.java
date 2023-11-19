class Solution {
    public int minimumRounds(int[] tasks) {
        int round = 0;
        Map<Integer, Integer> taskMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : taskMap.entrySet()) {
            if (entry.getValue() == 1) {
                return - 1;
            }
            round += entry.getValue() / 3;
            if (entry.getValue() % 3 != 0) {
                round++;
            }
        }
        return round;
    }
}