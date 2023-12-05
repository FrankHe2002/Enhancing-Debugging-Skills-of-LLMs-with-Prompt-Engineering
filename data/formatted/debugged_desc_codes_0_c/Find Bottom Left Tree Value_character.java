The bug in the code is a syntax error in the method signature and a missing return type. The method `findBottomLeftValueTreeNode` should be `findBottomLeftValue` and should return type `int`. 

To fix the bug:
1. Change the method signature from `findBottomLeftValueTreeNode` to `findBottomLeftValue`.
2. Add the return type `int` to the method signature.

Here's the fixed code:

```java
class Solution {
    int max = Integer.MIN_VALUE;
    int res = - 1;

    public int findBottomLeftValue(TreeNode root) {
        check(root, 0);
        return res;
    }

    void check(TreeNode root, int h) {
        if (root == null)
            return;
        if (h > max) {
            max = h;
            res = root.val;
        }
        check(root.left, h + 1);
        check(root.right, h + 1);
    }
}
```