```java
// Runtime: 0 ms (Top 100%) | Memory: 39.3 MB (Top 31.95%)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length - 1);
    }

    public TreeNode bst(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        int breakPoint = start + 1;
        while (breakPoint <= end && preorder[breakPoint] < preorder[start]) {
            breakPoint++;
        }

        root.left = bst(preorder, start + 1, breakPoint - 1);
        root.right = bst(preorder, breakPoint, end);
        return root;
    }
}
```