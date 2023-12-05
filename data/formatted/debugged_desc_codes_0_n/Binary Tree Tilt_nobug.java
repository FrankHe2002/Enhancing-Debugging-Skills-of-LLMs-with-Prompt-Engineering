```java
class Solution {
    int max = 0;

    public int findTilt(TreeNode root) {
        calculateTilt(root);
        return max;
    }

    public int calculateTilt(TreeNode root) {
        if (root == null) return 0;
        int left = calculateTilt(root.left);
        int right = calculateTilt(root.right);
        max += Math.abs(left - right);
        return root.val + left + right;
    }
}
```