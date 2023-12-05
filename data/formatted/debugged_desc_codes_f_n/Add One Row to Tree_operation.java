```java
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        insert(root, val, depth);
        return root;
    }
    
    public void insert(TreeNode node, int val, int depth) {
        if (node == null) {
            return;
        }
        if (depth == 2) {
            TreeNode left = node.left;
            node.left = new TreeNode(val);
            node.left.left = left;
            TreeNode right = node.right;
            node.right = new TreeNode(val);
            node.right.right = right;
        } else {
            insert(node.left, val, depth - 1);
            insert(node.right, val, depth - 1);
        }
    }
}
```