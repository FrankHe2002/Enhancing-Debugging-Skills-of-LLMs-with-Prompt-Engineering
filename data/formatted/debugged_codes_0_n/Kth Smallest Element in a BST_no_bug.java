class Solution {
    int element, count;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return element;
    }

    public void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, k);
        count++;

        if (count == k) {
            element = root.val;
            return;
        }

        inorderTraversal(root.right, k);
    }
}