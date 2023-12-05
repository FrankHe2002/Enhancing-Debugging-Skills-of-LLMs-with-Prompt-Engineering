```java
// Runtime: 1 ms (Top 198.74%) | Memory: 48.6 MB (Top 11.74%)
class Solution {

    int[] ans = new int[]{Integer.MIN_VALUE}; // Set initial max to lowest possible value

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans[0];
    }

    public int dfs(TreeNode root) {

        if (root == null)
            return 0;

        int left = Math.max(0, dfs(root.left)); 
        int right = Math.max(0, dfs(root.right)); 

        int maxInTheNode = root.val + left + right; 
        ans[0] = Math.max(ans[0], maxInTheNode);

        return root.val + Math.max(left, right);
    }
}
```