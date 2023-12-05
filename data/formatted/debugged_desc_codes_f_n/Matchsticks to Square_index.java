```java
class Solution {
    public boolean backtrack(int[] nums, int idx, int k, int subsetSum, int target, boolean[] vis) {
        if (k == 0)
            return true;
        if (subsetSum == target) {
            return backtrack(nums, 0, k - 1, 0, target, vis);
        }

        for (int i = idx; i < nums.length; i++) {
            if (vis[i] || subsetSum + nums[i] > target)
                continue;

            // Pruning
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
                continue;

            vis[i] = true;
            if (backtrack(nums, i + 1, k, subsetSum + nums[i], target, vis))
                return true;
            vis[i] = false;
        }

        return false;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int k = 4;
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        for (int match : matchsticks)
            sum += match;

        if (sum % k != 0)
            return false;

        int target = sum / k;
        boolean[] vis = new boolean[n];

        return backtrack(matchsticks, 0, k, 0, target, vis);
    }
}
```