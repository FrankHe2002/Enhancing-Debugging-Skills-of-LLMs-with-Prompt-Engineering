class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }

    private boolean helper(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null || x.val != y.val) return false;
        boolean similarity = helper(x.left, y.left) && helper(x.right, y.right);
        boolean swap = helper(x.left, y.right) && helper(x.right, y.left);

        return similarity || swap;
    }
}
