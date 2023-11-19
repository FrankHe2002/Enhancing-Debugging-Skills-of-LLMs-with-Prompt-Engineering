```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            List<Integer> nodesValues = new ArrayList<>();
            helperNodesVales(root, nodesValues);
            traverseAndAdd(root, nodesValues);
        }
        return root;
    }

    private void helperNodesVales(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            nodesValues.add(root.val);
            helperNodesVales(root.right, nodesValues);
            helperNodesVales(root.left, nodesValues);
        }
    }

    private void traverseAndAdd(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            int rootVal = root.val;
            for (int i = 0; i < nodesValues.size(); i++) {
                if (nodesValues.get(i) > rootVal)
                    root.val += nodesValues.get(i);
            }
            traverseAndAdd(root.right, nodesValues);
            traverseAndAdd(root.left, nodesValues);
        }
    }
}
```
