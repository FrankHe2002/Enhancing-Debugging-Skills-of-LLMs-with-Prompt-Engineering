import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        boolean flag = true;
        while (! q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (flag) {
                    curr.add(node.val);
                } else {
                    curr.add(0, node.val);
                }
            }
            flag = ! flag;
            res.add(curr);
        }
        return res;
    }
}