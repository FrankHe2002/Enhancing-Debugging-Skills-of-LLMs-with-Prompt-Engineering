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
    int count;

    public int kthSmallest(TreeNode root, int k) {
        return inorderTraversal(root, k);
    }


    public int inorderTraversal(TreeNode root, int k) {
        if (root.left != null) {
            int left = inorderTraversal(root.left, k);
            if (left != -1) {
                return left;
            }
        }
        count++;
        if (count == k) {
            return root.val;
        }

        if (root.right != null) {
            return inorderTraversal(root.right, k);
        }
        return -1;
    }
}
```