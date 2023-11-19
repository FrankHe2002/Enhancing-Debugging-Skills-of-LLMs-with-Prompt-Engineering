class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val == val) {
            return root;
        } else {
            TreeNode leftNode = searchBST(root.left, val);
            if (leftNode != null) {
                return leftNode;
            } else {
                return searchBST(root.right, val);
            }
        }
    }
}