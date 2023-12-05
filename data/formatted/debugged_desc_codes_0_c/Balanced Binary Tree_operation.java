The bug in the provided code is that the treeHeight method is being called twice for the left and right subtrees in the isBalanced method. This results in the height of the subtrees being calculated multiple times, which is redundant and inefficient. It would be more efficient to calculate the height and check for balance in a single traversal of the tree.

To fix this issue, I will calculate the height and check for balance within a single method call, thus reducing redundant calculations.

Here is the updated code with the fix:

```java
class Solution {

    public int treeHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = treeHeight(root.left);
        if (left == -1) return -1; // Left subtree is not balanced
        int right = treeHeight(root.right);
        if (right == -1) return -1; // Right subtree is not balanced

        if (Math.abs(left - right) > 1) return -1; // Subtree is unbalanced

        return (Math.max(left, right) + 1);
    }

    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) != -1;
    }
}
```

In the fixed code, the treeHeight method now returns -1 if the subtree is unbalanced and the isBalanced method checks for this condition. This prevents redundant calculations and ensures that the height and balance are checked in a single traversal of the tree.