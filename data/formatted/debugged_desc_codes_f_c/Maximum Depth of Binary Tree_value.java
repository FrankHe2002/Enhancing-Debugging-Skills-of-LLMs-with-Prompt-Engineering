```java
class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if (root == null) return 0; // Change 1 to 0 to represent no nodes
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}
```