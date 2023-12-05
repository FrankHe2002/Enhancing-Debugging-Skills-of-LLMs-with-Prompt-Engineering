```java
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (! q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode parent = q.remove();

                for (TreeNode child : new TreeNode[] {parent.left, parent.right}) {
                    if (child != null) {
                        q.add(child);
                        parentMap.put(child.val, parent);
                    }
                }
            }
            if (parentMap.containsKey(x) && parentMap.containsKey(y)) {
                return parentMap.get(x) != parentMap.get(y);
            }
        }
        return false;
    }
}
```