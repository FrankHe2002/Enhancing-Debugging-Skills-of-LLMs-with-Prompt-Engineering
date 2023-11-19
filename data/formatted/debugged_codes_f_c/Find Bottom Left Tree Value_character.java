The bug in the provided code is a syntax error in the method signature of `findBottomLeftValueTreeNode`. The correct method signature should be `findBottomLeftValue(TreeNode root)`.

Additionally, the indentation of the code is incorrect, making it difficult to read. The code should be properly indented for better readability.

Below is the fixed code:

```java
class Solution {
    int max = Integer.MIN_VALUE;
    int res = -1;

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