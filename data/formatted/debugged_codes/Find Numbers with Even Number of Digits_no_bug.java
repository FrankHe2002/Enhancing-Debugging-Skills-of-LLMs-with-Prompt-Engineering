class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int val : nums) {
            if ((val >= 10 && val <= 99) || (val >= 1000 && val <= 9999) || val == 100000) {
                count++;
            }
        }
        return count;
    }
}