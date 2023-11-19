class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] plants = new int[n][2];
        int totalPlantTime = 0;
        for (int i = 0; i < n; i++) {
            plants[i] = new int[] {plantTime[i], growTime[i]};
            totalPlantTime += plantTime[i];
        }
        Arrays.sort(plants, (a, b) -> a[1] - b[1]);
        int maxTime = 0;
        for (int[] plant : plants) {
            maxTime = Math.max(maxTime, totalPlantTime + plant[1]);
            totalPlantTime -= plant[1];
        }
        return maxTime;
    }
}