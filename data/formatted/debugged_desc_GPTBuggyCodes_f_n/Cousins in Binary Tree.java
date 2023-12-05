```java
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < len; i++) {
                TreeNode parent = q.remove();

                if (parent.left != null && parent.right != null) {
                    if ((parent.left.val == x && parent.right.val == y) || (parent.left.val == y && parent.right.val == x))
                        return false;
                }

                if (parent.val == x)
                    x_found = true;
                if (parent.val == y)
                    y_found = true;

                if (parent.left != null)
                    q.add(parent.left);
                if (parent.right != null)
                    q.add(parent.right);
            }
            if (x_found && y_found)
                return true;
            else if (x_found || y_found)
                return false;
        }
        return false;
    }
}
```