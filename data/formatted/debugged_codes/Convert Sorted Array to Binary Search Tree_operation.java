class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left_array = Arrays.copyOfRange(nums, 0, mid);
        int[] right_array = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.left = sortedArrayToBST(left_array);
        root.right = sortedArrayToBST(right_array);
        return root;
    }
}