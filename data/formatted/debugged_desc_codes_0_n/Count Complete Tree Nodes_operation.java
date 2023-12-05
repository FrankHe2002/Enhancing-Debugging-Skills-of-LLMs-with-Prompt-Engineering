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

    void countNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
    }

    public int countNodes(TreeNode root) {
        count = 0;
        countNodes(root);
        return count;
    }
}
```