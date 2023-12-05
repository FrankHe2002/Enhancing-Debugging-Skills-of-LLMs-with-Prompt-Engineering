The bug in the given code is that the inorderTraversal method is not using the result of recursive calls to inorderTraversal on the left and right children of the current node. It is simply calling these methods but not using their result. 

To fix this bug, the result of recursive calls to inorderTraversal on the left and right children of the current node should be included in the final list. This can be achieved by adding the result of these recursive calls to the main list `li`.

Here's the fixed code:

```java
class Solution {
    List<Integer> li = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return li;
        }
        inorderTraversal(root.left);
        li.add(root.val);
        inorderTraversal(root.right);
        return li;
    }
}
```

In the fixed code, we've removed the unnecessary creation of a new `LinkedList` when the root is null and included the result of recursive calls to inorderTraversal on the left and right children of the current node. This should resolve the bug.