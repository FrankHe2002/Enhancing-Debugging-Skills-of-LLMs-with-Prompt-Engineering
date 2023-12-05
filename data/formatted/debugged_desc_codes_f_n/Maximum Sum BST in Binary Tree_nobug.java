```java
// Runtime: 15 ms (Top 57.67%) | Memory: 71 MB (Top 82.51%)
class Solution {

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }

    // long[] = { min, max, sum, 1 for valid BST, 0 for invalid BST };
    private long[] solve(TreeNode root) {
        if (root == null)
            return new long[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};

        long[] left = solve(root.left);
        long[] right = solve(root.right);

        if (root.val > left[1] && root.val < right[0] && left[3] == 1 && right[3] == 1) {
            long sum = left[2] + right[2] + root.val;
            ans = Math.max(ans, (int) sum);
            return new long[] {Math.min(left[0], root.val), Math.max(root.val, right[1]), sum, 1};
        }

        return new long[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0};
    }

}
```