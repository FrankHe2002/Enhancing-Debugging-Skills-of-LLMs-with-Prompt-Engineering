```java
// Runtime: 14 ms (Top 14.50%) | Memory: 44.9 MB (Top 83.15%)
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        sum(root, map);

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        List<Integer> maxSumList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                maxSumList.add(key);
            }
        }

        int[] ans = new int[maxSumList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = maxSumList.get(i);
        }

        return ans;
    }

    public int sum(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        int lh = sum(root.left, map);
        int rh = sum(root.right, map);
        int currentSum = lh + rh + root.val;
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        return currentSum;
    }
}
```