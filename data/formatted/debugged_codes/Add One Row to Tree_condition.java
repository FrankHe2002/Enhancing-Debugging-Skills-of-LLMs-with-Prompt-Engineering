class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        findAndAdd(root, val, depth, 1);
        return root;
    }

    public void findAndAdd(TreeNode root, int val, int depth, int currDepth) {
        if (depth == 1 && currDepth == 1) {
            root = new TreeNode(val, root, null);
            return;
        }
        if (root == null)
            return;
        if (currDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            findAndAdd(root.left, val, depth, currDepth + 1);
            findAndAdd(root.right, val, depth, currDepth + 1);
        }
    }
}