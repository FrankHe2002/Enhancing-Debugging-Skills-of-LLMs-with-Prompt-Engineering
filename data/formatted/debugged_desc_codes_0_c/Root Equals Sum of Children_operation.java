```java
// Runtime: 1 ms (Top 77.34+) | Memory: 41.9 MB (Top 35.55%)
class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false; // edge case: if the root is null
        }
        if (root.left == null || root.right == null) {
            return false; // edge case: if either left child or right child is null
        }
        return root.val == root.left.val + root.right.val; // O(1)
    }
}
```