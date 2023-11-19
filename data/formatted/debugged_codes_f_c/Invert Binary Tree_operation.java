The bug in the provided code is that the `invertTree` method does not handle the case when the `root` node is null. If the `root` is null, the method should return null instead of attempting to access its left and right children.

To fix the bug, we can add a null check at the beginning of the `invertTree` method. If the `root` is null, we can simply return null. This ensures that the method handles the null case properly.

Fixed Code:
```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swap(root);
        return root;
    }

    private static void swap(TreeNode current) {
        if (current == null) {
            return;
        }

        swap(current.left);
        swap(current.right);

        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }
}
```