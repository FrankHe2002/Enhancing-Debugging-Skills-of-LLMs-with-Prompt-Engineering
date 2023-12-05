```java
// Runtime: 0 ms (Top 100.00%) | Memory: 50.7 MB (Top 10.84%)

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

    public int countNodes(TreeNode root) {
        int leftDepth = 0, rightDepth = 0;
        TreeNode leftNode = root, rightNode = root;

        while (leftNode != null) {
            leftDepth++;
            leftNode = leftNode.left;
        }

        while (rightNode != null) {
            rightDepth++;
            rightNode = rightNode.right;
        }

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
```