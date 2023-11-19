The bug in the provided code is that the `treeHeight` method is being called twice for each node in the `isBalanced` method. This results in redundant calculations and slower performance. 

To fix this, we can modify the `isBalanced` method to calculate the height of the tree and check if it meets the conditions for balance in a single traversal. 

Here is the fixed code:

```java
// Runtime: 0 ms | Memory: 38.7 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 / TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private int calculateHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = calculateHeight(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = calculateHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }
}
```

In the fixed code, we introduce a helper method `calculateHeight` that computes the height of the tree and checks if it is balanced in a single traversal. The method returns -1 if the tree is unbalanced, and the height of the tree otherwise.

In the `calculateHeight` method, if we encounter an imbalance at any point, we return -1 immediately, indicating that the tree is unbalanced. Otherwise, we compare the heights of the left and right subtrees and check if their absolute difference is greater than 1. If not, we return the maximum of the two heights plus 1.

In the `isBalanced` method, instead of calling `treeHeight` twice for each node, we call the `calculateHeight` method once. We check if the computed height is -1, which indicates an unbalanced tree. If the height is not -1, then the tree is balanced.