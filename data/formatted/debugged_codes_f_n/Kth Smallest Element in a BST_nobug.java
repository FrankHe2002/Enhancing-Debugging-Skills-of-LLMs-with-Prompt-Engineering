```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int element, count;

    public int kthSmallest(TreeNode root, int k) {
        count = 0; // Reset count before performing traversal
        inorderTraversal(root, k);
        return element;
    }


    public void inorderTraversal(TreeNode root, int k) {
        if (root == null) { // Base case for empty tree
            return;
        }
        
        inorderTraversal(root.left, k);
        count++;
        if (count == k) {
            element = root.val;
            return; // Exit traversal once kth element is found
        }

        inorderTraversal(root.right, k);
    }
}
```