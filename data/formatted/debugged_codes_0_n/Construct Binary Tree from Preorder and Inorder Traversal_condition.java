```java
class Solution {
    Map<Integer, Integer> inMap;
    int curIndex = 0;
    int[] preOrder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(0, preorder.length);
    }
    
    public TreeNode dfs(int s, int e) {
        if (s >= e) return null;
        int curNode = preOrder[curIndex++];
        TreeNode root = new TreeNode(curNode);
        int inRoot = inMap.get(curNode);
        root.left = dfs(s, inRoot);
        root.right = dfs(inRoot + 1, e);
        return root;
    }
}
```