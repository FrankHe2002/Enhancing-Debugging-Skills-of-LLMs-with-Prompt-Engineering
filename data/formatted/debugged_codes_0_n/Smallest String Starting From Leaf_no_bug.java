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
            if (result == null || sb.toString().compareTo(result) < 0) {
                result = sb.toString();
            }
            return;
        }
        build(root.left, sb);
        build(root.right, sb);
    }

    public char intToChar(int i) {
        return (char) (i + 'a');
    }
}