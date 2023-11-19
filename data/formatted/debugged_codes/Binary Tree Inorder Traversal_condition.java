class Solution {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorder(root);
        }
        return li;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            li.add(root.val);
            inorder(root.right);
        }
    }
}