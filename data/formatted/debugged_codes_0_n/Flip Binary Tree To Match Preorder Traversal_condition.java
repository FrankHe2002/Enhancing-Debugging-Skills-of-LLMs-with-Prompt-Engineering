```java
class Solution {
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        flipMatchVoyage(root, voyage, list);
        return list;
    }

    private void flipMatchVoyage(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null || list.contains(-1)) {
            return;
        }
        if (root.val != voyage[i++]) {
            list.clear();
            list.add(-1);
            return;
        }
        if (root.left != null && root.right != null && root.right.val == voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            list.add(root.val);
        }
        flipMatchVoyage(root.left, voyage, list);
        flipMatchVoyage(root.right, voyage, list);
    }
}
```