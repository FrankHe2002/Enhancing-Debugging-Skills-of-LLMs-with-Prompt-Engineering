```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.5 MB (Top 73.31%)
class Solution {
    TreeNode inRoot = null;
    TreeNode temp = null;

    public TreeNode increasingBST(TreeNode root) {
        inRoot = new TreeNode();
        temp = inRoot;
        inorder(root);
        return inRoot.right;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        inorder(root.right);
    }
}
```