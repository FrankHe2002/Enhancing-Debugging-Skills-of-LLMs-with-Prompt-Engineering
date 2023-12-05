```java
// Runtime: 179 ms (Top 13.99%) | Memory: 158.1 MB (Top 58.04%)

class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        //Map root value to tree
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode t : trees) {
            map.put(t.val, t);
        }

        // Merge trees
        for (int i = 0; i < trees.size(); i++) {
            TreeNode t = trees.get(i);
            if (map.containsKey(t.val) && i != 0) { // Check for i != 0 to prevent self-merge
                merger(t, map);
            }
        }

        //After merging we should have only one tree left else return null
        if (map.size() != 1) return null;
        else {
            TreeNode result = null;
            for (int c : map.keySet()) {
                TreeNode tree = map.get(c);
                //Check if final tree is valid else return null
                if (isValidBST(tree)) {
                    result = tree;
                } else {
                    return null;
                }
            }
            return result;
        }

    }

    void merger(TreeNode t, HashMap<Integer, TreeNode> map) {
        map.remove(t.val); // Remove current tree to prevent cyclical merging For. 2->3(Right) and 3->2(Left)
        //Merge on left
        if (t.left != null && map.containsKey(t.left.val)) {
            // Before merging child node, merge the grandchild nodes
            merger(t.left, map);
            t.left = map.get(t.left.val);
            map.remove(t.left.val);
        }

        // Merge on right
        if (t.right != null && map.containsKey(t.right.val)) {
            // Before merging child node, merge the grandchild nodes
            merger(t.right, map);
            t.right = map.get(t.right.val);
            map.remove(t.right.val);
        }
        // Add tree back to map once right and left merge is complete
        map.put(t.val, t);
    }

    // Validate BST
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
```