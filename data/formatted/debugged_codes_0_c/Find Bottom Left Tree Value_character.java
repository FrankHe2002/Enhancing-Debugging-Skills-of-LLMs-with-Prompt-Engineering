The bug in the provided code is a syntax error in the method signature of `findBottomLeftValueTreeNode` where a closing parenthesis is missing after `TreeNode root`. 

To fix this bug, we need to add the missing parenthesis in the method signature. Additionally, we should fix the method name to adhere to the camel case naming convention. 

Here is the fixed code:

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