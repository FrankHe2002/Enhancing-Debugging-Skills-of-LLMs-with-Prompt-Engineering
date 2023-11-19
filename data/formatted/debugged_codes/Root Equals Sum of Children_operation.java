class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == getSum(root.left) + getSum(root.right);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }
}