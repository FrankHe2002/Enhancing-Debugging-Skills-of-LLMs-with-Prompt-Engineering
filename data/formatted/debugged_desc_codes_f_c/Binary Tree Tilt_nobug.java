```java
// Runtime: 0 ms (Top 100.00%) | Memory: 45.7 MB (Top 24.54%)
class Solution {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        calculateTilt(root);
        return tilt;
    }

    public int calculateTilt(TreeNode root) {
        if (root == null) return 0;
        int left = calculateTilt(root.left);
        int right = calculateTilt(root.right);
        tilt += Math.abs(left - right);
        return root.val + left + right;
    }
}
```