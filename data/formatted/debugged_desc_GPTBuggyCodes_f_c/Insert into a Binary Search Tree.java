Explanation:
The original code correctly handles the insertion process for nodes in a binary search tree (BST). There are no visible bugs in the provided code.

Fix:
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val >= val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);

        return root;
    }
}
```