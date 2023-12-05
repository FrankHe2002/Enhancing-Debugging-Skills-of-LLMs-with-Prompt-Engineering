```java
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // if both are null, meaning they are flip equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) return false; // if only 1 of them is null or their values are different, meaning they are not flip equivalent

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || 
               (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right); // check both flip equivalent cases
    }
}
```