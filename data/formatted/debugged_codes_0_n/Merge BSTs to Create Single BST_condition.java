```java
// Runtime: 179 ms (Top 13.99%) | Memory: 158.1 MB (Top 58.04%)

class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        //Map root value to tree
        HashMap<Integer, TreeNode> map = new HashMap<>();
        boolean[] isMerged = new boolean[trees.size()];
        
        for (TreeNode t : trees) {
            map.put(t.val, t);
        }

        // Merge trees
        for (int i = 0; i < trees.size(); i++) {
            TreeNode t = trees.get(i);
            if (map.containsKey(t.val)) {
                merger(t, map, isMerged);
            }
        }

        //After merging we should have only one tree left else return null
        if (map.size() != 1) return null;
        else {
            //Return the one tree left after merging
            for (int c : map.keySet()) {
                //Check if final tree is valid else return null
                if (isValidBST(map.get(c))) {
                    return map.get(c);
                } else return null;
            }
        }

        return null;

    }

    void merger(TreeNode t, HashMap<Integer, TreeNode> map, boolean[] isMerged) {
        map.remove(t.val); // Remove current tree to prevent cyclical merging For. 2->3(Right) and 3->2(Left)
        //Merge on left
        if (t.left != null && map.containsKey(t.left.val)) {
            // Before merging child node, merge the grandchild nodes
            merger(map.get(t.left.val), map, isMerged);
            t.left = map.get(t.left.val);
            map.remove(t.left.val);
            isMerged[i] = true;
        }

        // Merge on right
        if (t.right != null && map.containsKey(t.right.val)) {
            // Before merging child node, merge the grandchild nodes
            merger(map.get(t.right.val), map, isMerged);
            t.right = map.get(t.right.val);
            map.remove(t.right.val);
            isMerged[i] = true;
        }
        // Add tree back to map once right and left merge is complete
        map.put(t.val, t);
    }

    // Validate BST
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min