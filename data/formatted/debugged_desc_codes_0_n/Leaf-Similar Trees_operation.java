```java
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        checkLeaf(root1, list1);
        checkLeaf(root2, list2);

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void checkLeaf(TreeNode node, List<Integer> arr) {
        if (node != null) {
            if (node.left == null && node.right == null) arr.add(node.val);
            if (node.left != null) checkLeaf(node.left, arr);
            if (node.right != null) checkLeaf(node.right, arr);
        }
    }
}
```