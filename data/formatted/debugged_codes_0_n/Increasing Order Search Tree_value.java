```java
// Runtime: 0 ms (Top 100.00%) | Memory: 40.5 MB (Top 73.31%)
class Solution {
    TreeNode inRoot = null;
    TreeNode temp = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return inRoot.right;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (inRoot == null) {
            inRoot = new TreeNode(root.val);
            temp = inRoot;
        } else {
            temp.right = new TreeNode(root.val);
            temp = temp.right;
        }
        inorder(root.right);
    }
}
```