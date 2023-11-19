class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> al = new LinkedList<>();
        List<List<Integer>> fal = new LinkedList<>();
        if (root == null) return fal;
        al.offer(root);
        while (! al.isEmpty()) {
            List<Integer> aal = new LinkedList<>();
            int num = al.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = al.poll();
                if (node.left != null) {
                    al.offer(node.left);
                }
                if (node.right != null) {
                    al.offer(node.right);
                }
                aal.add(node.val);
            }
            fal.add(0, aal);
        }
        return fal;
    }
}