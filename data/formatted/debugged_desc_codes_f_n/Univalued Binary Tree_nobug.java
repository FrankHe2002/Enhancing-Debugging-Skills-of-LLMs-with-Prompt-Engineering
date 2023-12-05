```java
class Solution {
    boolean ans = true;
    int firstVal = 0;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return ans;
        firstVal = root.val;
        if (!traversal(root))
            ans = false;
        return ans;
    }

    private boolean traversal(TreeNode root) {
        if (root == null)
            return true;
        if (root.val != firstVal)
            return false;
        return traversal(root.left) && traversal(root.right);
    }

}
```