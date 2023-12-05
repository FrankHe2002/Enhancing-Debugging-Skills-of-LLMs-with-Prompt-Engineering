The bug in the given code is in the base condition where it returns 1 when the root is null. The correct return value when the root is null should be 0 to represent that there are no nodes in the tree.

Here's the corrected code:

```java
class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if (root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}
```