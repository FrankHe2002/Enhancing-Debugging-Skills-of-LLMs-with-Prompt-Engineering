class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0, right = nums.length - 1;
        int start = 1;
        while (left < right) {
            while (left < right && nums[left] == nums[left + 1])
                ++ left;
            while (left < right && nums[right] == nums[right - 1])
                -- right;
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else right = mid;
        }
        start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else right = start;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}
