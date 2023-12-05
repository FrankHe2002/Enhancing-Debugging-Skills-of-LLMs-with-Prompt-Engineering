```java
// Runtime: 1 ms (Top 100.00%) | Memory: 43.8 MB (Top 78.96%)
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

        int mid = (column - 1) / 2;
        print(res, mid, level, root);

        return res;
    }

    public void print(List<List<String>> res, int mid, int level, TreeNode root) {
        if (root == null) return;
        res.get(level).set(mid, String.valueOf(root.val));

        print(res, mid - (1 << level - 1), level + 1, root.left);
        print(res, mid + (1 << level - 1), level + 1, root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
```