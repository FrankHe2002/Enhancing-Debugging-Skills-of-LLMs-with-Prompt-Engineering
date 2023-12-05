```java
// Runtime: 3 ms (Top 63.06%) | Memory: 39.3 MB (Top 90.4%)

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(List.of(root));
        List<Double> ans = new ArrayList<>();
        while (q.size() > 0) {
            double qlen = q.size(), row = 0;
            for (int i = 0; i < qlen; i++) {
                TreeNode curr = q.poll();
                row += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ans.add(row / qlen);
        }
        return ans;
    }
}
```