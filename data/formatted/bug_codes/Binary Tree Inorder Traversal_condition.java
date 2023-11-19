class Solution {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            List<Integer> li = new LinkedList<Integer>();
            return li;
        }
        inorderTraversal(root.left);
        li.add(root.val);
        inorderTraversal(root.right);
        return li;

    }

}