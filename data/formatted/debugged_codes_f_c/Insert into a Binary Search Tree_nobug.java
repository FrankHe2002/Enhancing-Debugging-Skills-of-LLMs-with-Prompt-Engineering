Bug Type: Syntax Error

Reasoning: The provided code is missing a semicolon at the end of the line `if (root.val > val) root.left = insertIntoBST(root.left, val)`. In Java, each statement should end with a semicolon.

Fix:
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) root.left = insertIntoBST(root.left, val);

        else root.right = insertIntoBST(root.right, val);

        return root;
    }
}
```