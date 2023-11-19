Fixed Code:
```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root.val <= min || root.val >= max)
            return false;
        boolean leftRight = true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null) {
            leftRight = dfs(root.left, min, root.val);
        }
        if (root.right != null) {
            leftRight = dfs(root.right, root.val, max) && leftRight;
        }
        return leftRight;
    }
}
```