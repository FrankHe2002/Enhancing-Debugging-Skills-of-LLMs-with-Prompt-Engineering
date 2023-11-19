class Solution {
    int element, count;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return element;
    }

    public void inorderTraversal(TreeNode root, int k) {
        if (root == null) { // Added null check
            return;
        }
        
        inorderTraversal(root.left, k);
        count++;
        
        if (count == k) {
            element = root.val;
            return; // Added return statement
        }
        
        inorderTraversal(root.right, k);
    }
}