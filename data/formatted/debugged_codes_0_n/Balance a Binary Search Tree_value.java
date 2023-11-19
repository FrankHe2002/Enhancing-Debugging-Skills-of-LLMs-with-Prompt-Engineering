```java
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        return sortedArrayToBST(arr, 0, arr.size() - 1);
    }

    public void inOrder(TreeNode node, List<Integer> arr) {
        if (node != null) {
            inOrder(node.left, arr);
            arr.add(node.val);
            inOrder(node.right, arr);
        }
    }

    public TreeNode sortedArrayToBST(List<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(arr.get(mid));
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
```