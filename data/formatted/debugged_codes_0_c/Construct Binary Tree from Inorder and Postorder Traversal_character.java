There is a missing ")" in the buildTree method signature: `public TreeNode buildTree(int low, int high {`. This is a syntax error and will cause a compilation error. 

To fix the bug, we need to add the missing ")" in the method signature: `public TreeNode buildTree(int low, int high) {`. Here is the corrected code:

```java
class Solution {
    int[] io;
    int[] po;
    int n;   // nth post order node 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.n = inorder.length - 1;
        this.io = inorder;
        this.po = postorder;
        return buildTree(0, n);
    }

    public TreeNode buildTree(int low, int high) {
        if (n < 0 || low > high) return null;
        int currNode = po[n--];
        int idxInInorder = low;
        TreeNode root = new TreeNode(currNode);
        if (low == high) return root;   // no more nodes

        while (io[idxInInorder] != currNode) idxInInorder++; // find index of currNode in inorder
        root.right = buildTree(idxInInorder + 1, high);
        root.left = buildTree(low, idxInInorder - 1);
        return root;
    }
}
```

The bug has been fixed by adding the missing ")" in the method signature.