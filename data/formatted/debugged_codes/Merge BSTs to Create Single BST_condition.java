class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode t : trees) {
            map.put(t.val, t);
        }
        for (TreeNode t : trees) {
            if (map.containsKey(t.val)) {
                merger(t, map);
            }
        }
        if (map.size() != 1) return null;
        for (int c : map.keySet()) {
            if (! isValidBST(map.get(c))) {
                return null;
            }
            return map.get(c);
        }

        return null;
    }

    void merger(TreeNode t, HashMap<Integer, TreeNode> map) {
        map.remove(t.val);
        if (t.left != null && map.containsKey(t.left.val)) {
            merger(map.get(t.left.val), map);
            t.left = map.get(t.left.val);
            map.remove(t.left.val);
        }
        if (t.right != null && map.containsKey(t.right.val)) {
            merger(map.get(t.right.val), map);
            t.right = map.get(t.right.val);
            map.remove(t.right.val);
        }
        map.put(t.val, t);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}