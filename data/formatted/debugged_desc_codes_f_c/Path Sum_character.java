Bug type: Syntax error

Explanation:
The error in the code is a missing semicolon (`;`) at the end of the statement `return root.val == targetSum`. Additionally, the code should handle both left and right subtrees.

Fix:
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return root.val == targetSum;

        return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
    }
}
```