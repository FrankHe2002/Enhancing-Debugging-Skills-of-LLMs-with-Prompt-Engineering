```java
class Solution {
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        if (flipMatchVoyage(root, voyage, list)) {
            return list;
        } else {
            return Arrays.asList(-1);
        }
    }

    private boolean flipMatchVoyage(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null) {
            return true;
        }
        if (i >= voyage.length || root.val != voyage[i++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            list.add(root.val);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return flipMatchVoyage(root.left, voyage, list) && flipMatchVoyage(root.right, voyage, list);
    }
}
```