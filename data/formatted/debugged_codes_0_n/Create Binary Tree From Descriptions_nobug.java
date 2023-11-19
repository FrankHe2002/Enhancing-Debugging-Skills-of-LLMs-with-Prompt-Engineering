```java
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int[] info : descriptions) {
            int parent = info[0];
            int child = info[1];
            boolean isLeft = info[2] == 1 ? true : false;
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            map.put(parent, parentNode);
            map.put(child, childNode);
            children.add(child);
        }
        TreeNode root = null;
        for (int[] info : descriptions) {
            if (!children.contains(info[1])) {
                root = map.get(info[1]);
                break;
            }
        }
        return root;
    }
}
```