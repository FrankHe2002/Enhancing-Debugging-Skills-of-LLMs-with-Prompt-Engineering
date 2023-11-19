class Solution {
    public int numTimesAllBlue(int[] flips) {
        int counter = 0;
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < flips.length; i++) {
            if (max < flips[i]) {
                max = flips[i];
            }
            if (++ counter == max) {
                total++;
            }
        }
        return total;
    }
}