class Solution {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 1, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i + 1] - nums[prev] <= k) continue;
            c++;
            prev = i;
        }
        return c;
    }
}
