```java
// Runtime: 0 ms (Top 100.00%) | Memory: 51.2 MB (Top 70.33-)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root; // Change made here
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
```