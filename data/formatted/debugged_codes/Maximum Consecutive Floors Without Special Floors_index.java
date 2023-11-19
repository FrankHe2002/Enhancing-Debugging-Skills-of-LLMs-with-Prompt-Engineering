class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = Integer.MIN_VALUE;

        Arrays.sort(special);
        max = Math.max(max, special[0] - bottom);
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        max = Math.max(max, top - special[special.length - 1]);

        return max;
    }
}