```java
class Solution {
    class TreeNode {
        int id;
        int val;
        List<TreeNode> child;
        
        public TreeNode(int id, int val) {
            this.id = id;
            this.val = val;
            child = new ArrayList<>();
        }
    }
    
    public int[] getCoprimes(int[] nums, int[][] edges) {
        TreeNode[] tr = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++)
            tr[i] = new TreeNode(i, nums[i]);
        for (int[] x : edges) {
            tr[x[0]].child.add(tr[x[1]]);
            tr[x[1]].child.add(tr[x[0]]);
        }
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        
        boolean[][] gcd = new boolean[51][51];
        for (int i = 1; i <= 50; i++) {
            for (int j = i; j <= 50; j++) {
                if (find_gcd(i, j) == 1) {
                    gcd[i][j] = true;
                    gcd[j][i] = true;
                }
            }
        }
        
        int[][] latest = new int[51][2];
        for (int i = 0; i <= 50; i++) {
            latest[i][0] = -1;
            latest[i][1] = -1;
        }
        
        find_closest_ancestor(tr[0], new TreeNode(-1, -1), ans, latest, gcd, 0);
        return ans;
    }
    
    public void find_closest_ancestor(TreeNode root, TreeNode parent, int[] ans, int[][] latest, boolean[][] gcd, int height) {
        int val = root.val;
        int latest_id = 0;
        
        for (int i = 1; i <= 50; i++) {
            if (gcd[val][i] && latest[latest_id][0] < latest[i][0])
                latest_id = i;
        }
        
        ans[root.id] = latest[latest_id][1];
        
        int pre_height = latest[val][0], pre_id = latest[val][1];
        latest[val][0] = height;
        latest[val][1] = root.id;
        
        for (TreeNode root_child : root.child) {
            if (root_child != parent)
                find_closest