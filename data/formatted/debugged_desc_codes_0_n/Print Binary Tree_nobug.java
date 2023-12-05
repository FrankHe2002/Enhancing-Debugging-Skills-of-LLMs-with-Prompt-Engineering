```java
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList();

        int height = getHeight(root);
        int row = height + 1;
        int column = (int) Math.pow(2, height + 1) - 1;

        for (int k = 0; k < row; k++) {
            List<String> list = new ArrayList();
            for (int i = 0; i < column; i++) {
                list.add("");
            }
            res.add(list);
        }

        int level = 0;
        print(root, res, (int) Math.pow(2, height) - 1, level, (int) Math.pow(2, height) - 1);

        return res;
    }

    public void print(TreeNode root, List<List<String>> res, int i, int j, int level) {
        if (root == null) return;
        res.get(level).set(j, Integer.toString(root.val));
        print(root.left, res, i / 2, j - i / 2 - 1, level + 1);
        print(root.right, res, i / 2, j + i / 2 + 1, level + 1);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
```