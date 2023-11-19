The bug in the provided code is that the condition in the first if statement is incorrect. Currently, it checks if the root is null and returns the root itself. However, in this case, we should return null instead.

To fix this bug, we need to modify the condition in the first if statement to return null when the root is null. Additionally, we can simplify the code by removing the else block.

Here is the fixed code:

```java
// Runtime: 0 ms (Top 100.00%) | Memory: 51.2 MB (Top 70.33%)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
```