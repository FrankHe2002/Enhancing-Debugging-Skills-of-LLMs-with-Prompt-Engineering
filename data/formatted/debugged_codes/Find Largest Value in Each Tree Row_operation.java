class Solution {
    private List<Integer> li = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) return li;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (! q.isEmpty()) {
            int size = q.size();
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                res = Math.max(res, temp.val);
            }
            li.add(res);
        }
        return li;
    }