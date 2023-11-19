```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else {
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}
```