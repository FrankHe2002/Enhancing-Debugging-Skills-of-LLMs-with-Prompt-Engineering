The bug in the given code is a syntax error. The increment operator is missing in the line `count++`.

To fix this bug:
1. Add the increment operator `++` to the line `count++`.
2. Add a semicolon at the end of the line `count++`.

Here is the corrected code:

```java
class Solution {
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        if (helper(root) == - 1)
            count++;
        return count;
    }

    //post order
    //0 - have camera
    //1 - covered
    //-1 - not covered
    public int helper(TreeNode root) {
        if (root == null)
            return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == - 1 || right == - 1) {
            count++;
            return 0;
        }
        if (left == 0 || right == 0)
            return 1;

        return - 1;
    }
}
```