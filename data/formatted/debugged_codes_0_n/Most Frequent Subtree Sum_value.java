```java
// Runtime: 1 ms | Memory: 39.5 MB
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = sum(root, map);
        int max = 0;
        int count = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                count++;
            }
        }
        int[] ans = new int[count];
        int counter = 0;
        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                ans[counter++] = key;
            }
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