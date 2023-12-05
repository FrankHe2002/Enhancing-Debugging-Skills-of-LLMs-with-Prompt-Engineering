```java
class Solution {
    private int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        if(flipMatchVoyage(root, voyage, list)){
            return list;
        } else {
            return Collections.singletonList(-1);
        }
    }

    private boolean flipMatchVoyage(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[i++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            list.add(root.val);
            return flipMatchVoyage(root.right, voyage, list) && flipMatchVoyage(root.left, voyage, list);
        }
        return flipMatchVoyage(root.left, voyage, list) && flipMatchVoyage(root.right, voyage, list);
    }
}
```