```java
// Runtime: 2 ms (Top 63.11%) | Memory: 44.6 MB (Top 8.84%)
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // O(n) time | O(h) space
        if (preorder == null || postorder == null || preorder.length == 0 || postorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;

        int mid = 0;
        // update mid
        for (int i = 0; i < postorder.length; i++) {
            if (preorder[1] == postorder[i]) {
                mid = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(postorder, 0, mid));

        root.right = constructFromPrePost(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(postorder, mid, postorder.length - 1));
        return root;
    }
}
```