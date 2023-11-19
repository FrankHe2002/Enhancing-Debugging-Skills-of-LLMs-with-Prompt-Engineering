```java
class Solution {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return li; // Removed unnecessary creation of List<Integer> li
        }
        inorderTraversal(root.left);
        li.add(root.val);
        inorderTraversal(root.right);
        return li;
    }
}
```