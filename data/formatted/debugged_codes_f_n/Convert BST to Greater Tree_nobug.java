Fixed Code:
```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            List<Integer> nodesValues = new ArrayList<>();
            helperNodesValues(root, nodesValues);
            traverseAndAdd(root, nodesValues);
            return root;
        }
        return null;
    }

    private void helperNodesValues(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            nodesValues.add(root.val);
        }
        if (root.right != null) {
            helperNodesValues(root.right, nodesValues);
        }
        if (root.left != null) {
            helperNodesValues(root.left, nodesValues);
        }
    }

    private void traverseAndAdd(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            int rootVal = root.val;
            for (int i = 0; i < nodesValues.size(); i++) {
                if (nodesValues.get(i) > rootVal)
                    root.val += nodesValues.get(i);
            }
        }
        if (root.right != null) {
            traverseAndAdd(root.right, nodesValues);
        }
        if (root.left != null) {
            traverseAndAdd(root.left, nodesValues);
        }
    }
}
```