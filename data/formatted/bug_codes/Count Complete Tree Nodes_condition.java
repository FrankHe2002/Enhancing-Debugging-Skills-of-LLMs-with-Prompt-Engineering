class Solution {

    static int count = 0;

    static void Postorder(TreeNode root) {
        if (root != null) {
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        count++;
    }

    public int countNodes(TreeNode root) {
        count = 0;
        Postorder(root);
        return count;
    }
}