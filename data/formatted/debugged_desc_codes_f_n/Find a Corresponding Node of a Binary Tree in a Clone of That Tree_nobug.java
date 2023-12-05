```java
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(cloned, target);
    }

    public static TreeNode dfs(TreeNode root, TreeNode target) {
        if (root == null) return null;
        if (root.val == target.val) return root;
        
        TreeNode left = dfs(root.left, target);
        if (left != null) return left;
        
        TreeNode right = dfs(root.right, target);
        return right;
    }
}
```