class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] maxCount = new int[1];
        sum(root, map, maxCount);
        
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount[0]) {
                count++;
            }
        }
        
        int[] ans = new int[count];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount[0]) {
                ans[index++] = key;
            }
        }
        
        return ans;
    }
    
    public int sum(TreeNode root, HashMap<Integer, Integer> map, int[] maxCount) {
        if (root == null) return 0;
        int lh = sum(root.left, map, maxCount);
        int rh = sum(root.right, map, maxCount);
        int sum = lh + rh + root.val;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount[0] = Math.max(maxCount[0], map.get(sum));
        
        return sum;
    }
}