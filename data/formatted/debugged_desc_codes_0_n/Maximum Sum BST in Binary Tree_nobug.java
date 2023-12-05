```java
class Solution {

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }

    // int[] = { min, max, sum, isValid };
    private int[] solve(TreeNode root) {
        if (root == null)
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        if (left[3] == 1 && right[3] == 1 && (root.left == null || root.val > left[1]) && (root.right == null || root.val < right[0])) {
            int sum = left[2] + right[2] + root.val;
            ans = Math.max(ans, sum);
            return new int[] { Math.min(left[0], root.val), Math.max(root.val, right[1]), sum, 1};
        }

        return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0};
    }
}
```