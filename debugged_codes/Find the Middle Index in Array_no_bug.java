// Runtime: 0 ms (Top 100%) | Memory: 38.7 MB (Top 93.88%)

class Solution {
    public int findMiddleIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int lsum = 0;
            int rsum = 0;

            for (int j = 0; j < i; j++) {
                lsum += nums[j];
            }

            for (int k = i + 1; k < nums.length; k++) {
                rsum += nums[k];
            }

            if (lsum == rsum) {
                return i;
            }
        }

        return -1;
    }
}