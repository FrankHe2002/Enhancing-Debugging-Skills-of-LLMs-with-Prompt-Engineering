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
            helperNodesValues(root.right, nodesValues);
            helperNodesValues(root.left, nodesValues);
        }
    }

    private void traverseAndAdd(TreeNode root, List<Integer> nodesValues) {
        if (root != null) {
            int rootVal = root.val;
            for (int i = 0; i < nodesValues.size(); i++) {
                if (nodesValues.get(i) > rootVal) {
                    root.val += nodesValues.get(i);
                }
            }
            traverseAndAdd(root.right, nodesValues);
            traverseAndAdd(root.left, nodesValues);
        }
    }
}