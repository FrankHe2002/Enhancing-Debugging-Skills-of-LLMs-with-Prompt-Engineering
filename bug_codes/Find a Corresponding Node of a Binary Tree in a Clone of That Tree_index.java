class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode[] ref = new TreeNode[]{null};
        dfs(cloned, target, ref);
        return ref[target];
    }
    public static void dfs (TreeNode root, TreeNode target, TreeNode[] ref) {
        if (root == null) return;
        if (root.val == target.val) {
            ref[0] = root;
            return;
        } else {
            dfs(root.left, target, ref);
            dfs(root.right, target, ref);
        }
    }
}
