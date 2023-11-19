// Runtime: 0 ms (100.00%) | Memory: 38.8 MB (91.50%)
class Solution {

    public int treeHeight(TreeNode root){
        if (root == null)
            return 0;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return ( Math.max(left,right) + 1);

    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        boolean leftBalanced = isBalanced( root.left);
        boolean rightBalanced = isBalanced( root.right);
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        // Return true only when all conditions are true
        return (leftBalanced && rightBalanced && Math.abs(leftHeight - rightHeight) <= 1);

    }
}