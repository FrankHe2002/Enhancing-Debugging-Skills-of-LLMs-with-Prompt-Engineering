```java
// Runtime: 0 ms (Top 100.00+) | Memory: 36.6 MB (Top 5.37%)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return swap(root);
    }

    private static TreeNode swap(TreeNode current) {
        if (current == null) {
            return null;
        }

        TreeNode left = swap(current.left);
        TreeNode right = swap(current.right);

        current.left = right;
        current.right = left;

        return current;
    }
}
```