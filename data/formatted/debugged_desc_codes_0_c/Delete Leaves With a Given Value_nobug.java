The bug in the code is that when the condition for deleting a leaf node with the value target is met, the code sets the root to null, but it does not handle the parent node becoming a leaf node and having the value target as required.

To fix the bug, the code needs to check if the root becomes a leaf node and has the value target after deleting its child nodes. If so, the code should also delete the parent node, and continue doing so recursively until it cannot.

Here's the fixed code:

```java
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }
}
```