class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minInd = 0;
        int maxInd = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minInd = i;
            }
        }
        if (maxInd == minInd) {
            return Math.min(maxInd + 1, n - maxInd);
        }
        if (maxInd > minInd) {
            int count = Math.min(maxInd + 1, n - minInd);
            int count1 = minInd + 1 + (n - maxInd);
            return Math.min(count, count1);
        } else {
            int count = Math.min(minInd + 1, n - maxInd);
            int count1 = maxInd + 1 + (n - minInd);
            return Math.min(count, count1);
        }

    }
}