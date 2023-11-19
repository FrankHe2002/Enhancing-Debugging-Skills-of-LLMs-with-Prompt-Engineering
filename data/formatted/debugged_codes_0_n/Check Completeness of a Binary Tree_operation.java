```java
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return true;
    }
}
```