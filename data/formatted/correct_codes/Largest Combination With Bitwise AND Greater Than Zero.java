class Solution {
    public static int largestCombination(int[] candidates) {
        int arr[] = new int[32];
        for (int i = 0; i < candidates.length; i++) {
            String temp = Integer.toBinaryString(candidates[i]);
            int n = temp.length();
            int index = 0;
            while (n-- > 0) {
                arr[index++] += temp.charAt(n) - '0';
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < 32; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}