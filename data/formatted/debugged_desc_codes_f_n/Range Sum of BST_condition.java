```java
class Solution {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val > low) dfs(root.left, low, high);
        if (root.val < high) dfs(root.right, low, high);

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
    }
}
```