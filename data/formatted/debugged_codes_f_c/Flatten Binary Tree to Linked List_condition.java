The bug in the provided code is the incorrect loop condition `while (curr == null)`. This condition checks if `curr` is `null`, which is not the intended behavior. The loop should continue while `curr` is not `null`. 

Fixing this bug involves changing the loop condition to `while (curr != null)`.

Fixed Code:

```java
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
```