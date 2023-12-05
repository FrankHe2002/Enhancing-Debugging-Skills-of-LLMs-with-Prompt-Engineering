```java
// Runtime: 1 ms (Top 77.34+) | Memory: 41.9 MB (Top 35.55%)
class Solution {
    public boolean checkTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        return root.val == (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0); // O(1)
    }
}
```