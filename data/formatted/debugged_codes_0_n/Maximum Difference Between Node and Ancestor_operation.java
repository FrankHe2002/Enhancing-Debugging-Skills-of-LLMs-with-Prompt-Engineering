```java
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return find(root, root.val, root.val);
    }

    public int find(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        
        return Math.max(find(root.left, min, max), find(root.right, min, max));
    }
}
```