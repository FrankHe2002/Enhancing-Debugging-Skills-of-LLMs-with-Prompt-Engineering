class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        HashSet<String> hashes = new HashSet<String>();
        HashSet<String> added = new HashSet<String>();

        Stack<TreeNode> s = new Stack<TreeNode>();

        s.add(root);
        while (! s.isEmpty()) {
            TreeNode tmp = s.pop();
            dfs(tmp, new StringBuilder(), tmp, list, hashes, added);

            if (tmp.left != null) {
                s.add(tmp.left);
            }
            if (tmp.right != null) {
                s.add(tmp.right);
            }
        }

        return list;

    }

    public void dfs(TreeNode parent, StringBuilder hash, TreeNode root, List<TreeNode> list, HashSet<String> set, HashSet<String> added) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.add(root);
        hash.append(root.val).append("ROOT,");
        while (! stack.isEmpty()) {
            TreeNode tmp = stack.pop();

            if (tmp.left != null) {
                hash.append(tmp.left.val).append("L,");
                stack.add(tmp.left);
            } else {
                hash.append("NULLL,");
            }
            if (tmp.right != null) {
                hash.append(tmp.right.val).append("R,");
                stack.add(tmp.right);
            } else {
                hash.append("NULLR,");
            }
            if (tmp.left == null && tmp.right == null && stack.isEmpty()) {
                String h = hash.toString();
                if (set.contains(h)) {
                    if (! added.contains(h)) {
                        list.add(parent);
                        added.add(h);
                    }
                } else {
                    set.add(h);
                }
                return;
            }

        }
    }
}