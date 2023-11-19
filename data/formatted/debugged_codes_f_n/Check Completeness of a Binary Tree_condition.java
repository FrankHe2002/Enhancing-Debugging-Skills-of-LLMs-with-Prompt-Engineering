```java
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode != null) {
                end = true;
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            } else {
                if (end) {
                    return false;
                }
            }
        }
        return true;
    }
}
```