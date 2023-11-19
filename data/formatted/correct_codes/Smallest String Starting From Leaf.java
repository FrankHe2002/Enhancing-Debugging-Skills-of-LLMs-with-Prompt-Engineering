class Solution {
    String result = null;

    public String smallestFromLeaf(TreeNode root) {
        build(root, new StringBuilder());
        return result;
    }

    public void build(TreeNode root, StringBuilder str) {
        if (root == null) return;

        StringBuilder sb = new StringBuilder(str).insert(0, String.valueOf(intToChar(root.val)));

        if (root.left == null && root.right == null) {
            result = result == null || sb.toString().compareTo(result) < 0 ? sb.toString() : result;
            return;
        }
        build(root.left, sb);
        build(root.right, sb);
    }

    public Character intToChar(int i) {
        return (char) (i + 'a');
    }
}