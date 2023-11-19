class Solution {

    private static class MNode {
        TreeNode Node;
        int hDist;
        int level;

        MNode(TreeNode node, int hd, int l) {
            Node = node;
            hDist = hd;
            level = l;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<MNode>> map = new TreeMap<>();
        Queue<MNode> q = new LinkedList<>();

        q.add(new MNode(root, 0, 0));

        while (! q.isEmpty()) {

            MNode curr = q.poll();
            if (map.containsKey(curr.hDist))
                map.get(curr.hDist).add(curr);

            else {
                PriorityQueue<MNode> pq = new PriorityQueue<>
                        ((a, b) -> {
                            if (a.level == b.level) {
                                return a.Node.val - b.Node.val;
                            } else {
                                return a.level - b.level;
                            }
                        });
                pq.add(curr);
                map.put(curr.hDist, pq);
            }

            if (curr.Node.left != null)
                q.add(new MNode(curr.Node.left, curr.hDist - 1, curr.level + 1));

            if (curr.Node.right != null)
                q.add(new MNode(curr.Node.right, curr.hDist + 1, curr.level + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            while (! map.get(key).isEmpty()) {
                temp.add(map.get(key).poll().Node.val);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;

    }

}