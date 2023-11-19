```java
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode[] ref = new TreeNode[] {null};
        dfs(original, cloned, target, ref);
        return ref[0];
    }

    public static void dfs(TreeNode original, TreeNode cloned, TreeNode target, TreeNode[] ref) {
        if (original == null) return;
        if (original == target) {
            ref[0] = cloned;
            return;
        }
        dfs(original.left, cloned.left, target, ref);
        dfs(original.right, cloned.right, target, ref);
    }
}
```