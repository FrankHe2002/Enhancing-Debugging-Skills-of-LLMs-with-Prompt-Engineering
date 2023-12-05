```java
class Solution {

    HashMap<Integer, List<TreeNode>> parent_val_child_nodes_map;
    HashMap<Integer, TreeNode> child_val_parent_node_map;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        // initialize map
        parent_val_child_nodes_map = new HashMap<>();
        child_val_parent_node_map = new HashMap<>();

        // fill map
        dfsFillMap(root);

        // store the root node
        List<TreeNode> result = new ArrayList<>();

        searchAndDelete(to_delete, result, root);

        if (!Arrays.stream(to_delete).anyMatch(j -> j == root.val)) {
            result.add(root);
        }

        return result;
    }

    public void searchAndDelete(int[] to_delete, List<TreeNode> result, TreeNode current) {
        if (current == null) {
            return;
        }

        if (current.left != null && Arrays.stream(to_delete).anyMatch(j -> j == current.left.val)) {
            result.add(current.left);
            current.left = null;
        }

        if (current.right != null && Arrays.stream(to_delete).anyMatch(j -> j == current.right.val)) {
            result.add(current.right);
            current.right = null;
        }

        searchAndDelete(to_delete, result, current.left);
        searchAndDelete(to_delete, result, current.right);
    }

    public void dfsFillMap(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parent_val_child_nodes_map.putIfAbsent(root.val, new ArrayList<>());
            parent_val_child_nodes_map.get(root.val).add(root.left);

            child_val_parent_node_map.putIfAbsent(root.left.val, root);
            dfsFillMap(root.left);
        }

        if (root.right != null) {
            parent_val_child_nodes_map.putIfAbsent(root.val, new ArrayList<>());
            parent_val_child_nodes_map.get(root.val).add(root.right);

            child_val_parent_node_map.putIfAbsent(root.right.val, root);
            dfsFillMap(root.right);
        }

        return;
    }
}
```