class Solution {

    List<Integer> set1, set2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        set1 = new ArrayList<>();
        set2 = new ArrayList<>();

        getLeafNodes(root1, set1);
        getLeafNodes(root2, set2);

        return set1.equals(set2);
    }

    public void getLeafNodes(TreeNode root, List<Integer> set) {
        if (root == null)
            return;

        getLeafNodes(root.left, set);

        if (root.left == null && root.right == null) {
            if (set == null) {
                set = new ArrayList<Integer>();
            }
            set.add(root.val);
            return;
        }

        getLeafNodes(root.right, set);
    }
}