```java
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return findAndAdd(root, val, depth, 1);
    }

    public TreeNode findAndAdd(TreeNode root, int val, int depth, int currDepth) {
        if (depth == 1 && currDepth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        
        if (root == null) {
            return null;
        }
        
        if (currDepth == depth - 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root.left;
            root.left = newNode;
            
            newNode = new TreeNode(val);
            newNode.right = root.right;
            root.right = newNode;
        } else {
            root.left = findAndAdd(root.left, val, depth, currDepth + 1);
            root.right = findAndAdd(root.right, val, depth, currDepth + 1);
        }
        
        return root;
    }
}
```