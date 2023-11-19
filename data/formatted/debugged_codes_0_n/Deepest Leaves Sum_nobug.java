```java
// Runtime: 5 ms (Top 33.80%) | Memory: 42.2 MB (Top 5.81%)
class Solution {
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int hght = height(root);
        int sum = 0;
        while (!q.isEmpty() && q.peek() != null) {
            TreeNode temp = q.remove();
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            if (q.peek() == null) {
                q.remove();
                q.add(null);
                hght--;
            }
            if (hght == 1) {
                while (!q.isEmpty() && q.peek() != null) {
                    sum += q.remove().val;
                }
            }
        }
        return sum;
    }
}
```