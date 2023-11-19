```java
class Solution {
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        flipMatchVoyageHelper(root, voyage, list);
        return list;
    }

    private void flipMatchVoyageHelper(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null || list.contains(-1)) {
            return;
        }
        if (root.val != voyage[i++]) {
            list.clear();
            list.add(-1);
            return;
        }
        if (root.left != null && root.right != null && root.left.val != voyage[i]) {
            list.add(root.val);
            flipMatchVoyageHelper(root.right, voyage, list);
            flipMatchVoyageHelper(root.left, voyage, list);
            return;
        }
        flipMatchVoyageHelper(root.left, voyage, list);
        flipMatchVoyageHelper(root.right, voyage, list);
    }
}
```
