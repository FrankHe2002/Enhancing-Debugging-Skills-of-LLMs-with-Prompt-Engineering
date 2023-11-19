class Solution {
    int ans = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        ans = Math.max(ans, lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}

