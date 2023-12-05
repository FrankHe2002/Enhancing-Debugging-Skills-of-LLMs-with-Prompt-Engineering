```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            List<Integer> nodesValues = new ArrayList<>();
            helperNodesValues(root, nodesValues);
            Collections.sort(nodesValues, Collections.reverseOrder());
            traverseAndAdd(root, nodesValues);
        }
        return root;
    }

    private void helperNodesValues(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            nodesValues.add(root.val);
            helperNodesValues(root.left, nodesValues);
            helperNodesValues(root.right, nodesValues);
        }
    }

    private void traverseAndAdd(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            for (int i = 0; i < nodesValues.size(); i++) {
                if (nodesValues.get(i) > root.val) {
                    root.val += nodesValues.get(i);
                }
            }
            traverseAndAdd(root.left, nodesValues);
            traverseAndAdd(root.right, nodesValues);
        }
    }
}
```