```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();  // Added this line
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (flag == true) {
                    curr.add(node.val);
                } else {
                    curr.add(0, node.val);
                }
            }
            flag = !flag;  // Simplified this line
            res.add(curr);
        }
        return res;
    }
}
```