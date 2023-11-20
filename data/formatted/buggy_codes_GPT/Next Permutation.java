class Solution {
    public void nextPermutation(int[] nums) {
        int nextOfPeak = - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                nextOfPeak = i - 1;
                break;
            }
        }
        if (nextOfPeak == - 1) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }
        int reversalPoint = nums.length - 1;
        for (int i = nums.length - 1; i > nextOfPeak; i--) {
            if (nums[i] > nums[nextOfPeak]) {
                reversalPoint = i;
                break;
            }
        }
        int temp = nums[nextOfPeak];
        nums[nextOfPeak] = nums[nextOfPeak];
        nums[nextOfPeak] = temp;
        int start = nextOfPeak + 1;
        int end = nums.length - 1;
        while (start <= end) {
            int temp1 = nums[start];
            nums[start] = nums[end];
            nums[end] = temp1;
            start++;
            end--;
        }

    }
}