The bug in this code is related to the condition `depth == 1 && currDepth == 1` inside the `findAndAdd` method. This condition is used to handle the case where the new row needs to be added at the root level. However, it doesn't handle the case where the depth is greater than 1.

To fix this bug, we need to modify the condition to `depth == 1 && currDepth == 2`. This change ensures that the new row is only added when we are at the level right above the desired depth.

Here's the fixed code:

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        findAndAdd(root, val, depth, 1);
        return root;
    }

    public void findAndAdd(TreeNode root, int val, int depth, int currDepth) {
        if (depth == 1 && currDepth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        if (root == null)
            return;
        if (currDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            findAndAdd(root.left, val, depth, currDepth + 1);
            findAndAdd(root.right, val, depth, currDepth + 1);
        }
    }
}
```