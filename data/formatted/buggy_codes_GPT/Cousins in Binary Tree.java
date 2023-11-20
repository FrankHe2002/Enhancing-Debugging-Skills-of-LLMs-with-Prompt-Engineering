// Runtime: 2 ms (Top 20.27%) | Memory: 42 MB (Top 40.06%)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Set<TreeNode> parentSet = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (! q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode parent = q.remove();

                for (TreeNode child : new TreeNode[] {parent.left, parent.right}) {
                    if (child != null) {
                        q.add(child);
                        if (child.val == x || child.val == y)
                            parentSet.add(parent);
                    }
                }
            }
            if (parentSet.size() > 0)
                return parentSet.size() == 3; // changed 2 to 3
        }
        return false;
    }
}