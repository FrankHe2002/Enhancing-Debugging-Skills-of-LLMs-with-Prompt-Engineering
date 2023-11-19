class Solution {
    
    private int getAbsoluteDifference(int a, int b){
        return Math.abs(a - b);
    }
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++)
            result += getAbsoluteDifference(nums[i], nums[i+1]);
        
        int minLine = Integer.MAX_VALUE; // Changed from Integer.MIN_VALUE
        int maxLine = Integer.MIN_VALUE; // Changed from Integer.MAX_VALUE
        for (int i = 0; i <= n - 1; i++) { // Changed from i < n - 1 to i <= n - 1
            minLine = Math.min(minLine, Math.min(nums[i], nums[i + 1])); // Changed from Math.max to Math.min
            maxLine = Math.max(maxLine, Math.max(nums[i], nums[i + 1])); // Changed from Math.min to Math.max
        }
        int diff = Math.max(0, (minLine - maxLine) * 2);
        for (int i = 1; i < n - 1; i++)
            diff = Math.max(diff, getAbsoluteDifference(nums[0], nums[i+1]) - getAbsoluteDifference(nums[i], nums[i+1]));
        
        for (int i = 0; i < n - 1; i++)
            diff = Math.max(diff, getAbsoluteDifference(nums[n-1], nums[i]) - getAbsoluteDifference(nums[i+1], nums[i]));
        return result + diff;
    }
}