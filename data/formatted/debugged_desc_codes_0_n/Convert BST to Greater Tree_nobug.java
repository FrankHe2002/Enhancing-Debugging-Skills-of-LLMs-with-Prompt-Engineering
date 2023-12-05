```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {


            List<Integer> nodesValues = new ArrayList<>();
            helperNodesVales(root, nodesValues);
            traverseAndAdd(root, nodesValues);

            return root;
        }
        return null;
    }

    private void helperNodesVales(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            helperNodesVales(root.right, nodesValues);
            nodesValues.add(root.val);
            helperNodesVales(root.left, nodesValues);
        }
    }

    private void traverseAndAdd(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            traverseAndAdd(root.right, nodesValues);
            int sum = 0;
            for (int i = 0; i < nodesValues.size(); i++) {
                if (nodesValues.get(i) > root.val)
                    sum += nodesValues.get(i);
            }
            root.val += sum;
            traverseAndAdd(root.left, nodesValues);
        }
    }
}
```