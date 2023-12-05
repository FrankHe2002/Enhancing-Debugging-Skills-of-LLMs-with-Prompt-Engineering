Fix:
```java
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int[] info : descriptions) {
            int parent = info[0], child = info[1];
            boolean isLeft = info[2] == 1;
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
			TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            if (isLeft)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;
            map.put(parent, parentNode);
            map.put(child, childNode);
        }
        TreeNode root = null;
        for (int[] info : descriptions) {
            if (!map.containsKey(info[1])) {
                root = map.get(info[0]);
                break;
            }
        }
        return root;
    }
}
```