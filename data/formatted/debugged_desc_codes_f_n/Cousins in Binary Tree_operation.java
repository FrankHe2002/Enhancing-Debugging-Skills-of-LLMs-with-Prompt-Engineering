```java
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left.val, node.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right.val, node.val);
                }
            }
            if (map.containsKey(x) || map.containsKey(y)) {
                return (map.containsKey(x) && map.containsKey(y) && !map.get(x).equals(map.get(y)));
            }
        }
        return false;
    }
}
```