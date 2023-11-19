class Solution {
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        qu.add(root);
        while(!qu.isEmpty()) {
            TreeNode tmp = qu.poll();
            if(map.containsKey(tmp.val)) {
                map.put(tmp.val, map.get(tmp.val)+1);
            }
            else {
                map.put(tmp.val, 1);
            }
            if(tmp.left!=null) qu.add(tmp.left);
            if(tmp.right!=null) qu.add(tmp.right);
        }
        int max = Integer.MIN_VALUE;
        for(Integer key : map.keySet()) {
            if(map.get(key)>max) {
                list.clear();
                max = map.get(key);
                list.add(key);
            }
            else if(max==map.get(key)) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}