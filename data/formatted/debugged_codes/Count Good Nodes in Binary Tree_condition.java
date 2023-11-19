class Solution {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode root, int mx) {
        if (root == null) return;

        if (mx <= root.val) ans++;
        mx = Math.max(mx, root.val);

        dfs(root.left, mx);
        dfs(root.right, mx);

    }
}