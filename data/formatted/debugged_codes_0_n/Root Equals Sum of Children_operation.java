```java
// Runtime: 1 ms (Top 77.34+) | Memory: 41.9 MB (Top 35.55%)
class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            return true;
        }
        
        int sum = 0;
        
        if (root.left != null) {
            sum += root.left.val;
        }
        
        if (root.right != null) {
            sum += root.right.val;
        }
        
        return root.val == sum;
    }
}
```