class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                result[left++] = nums[i];
            }
            else if(nums[i] > pivot) {
                result[right--] = nums[i];
            }
        }

        while(left <= right) {
            result[left++] = pivot;
            result[right--] = pivot;
        }

        return result;
    }
}