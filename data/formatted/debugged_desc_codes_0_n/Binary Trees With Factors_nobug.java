```java
class Solution {
    int mod = 1000000007;
    HashMap<Integer, Long> dp;
    HashSet<Integer> set;

    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 0;
        dp = new HashMap<>();
        set = new HashSet<>();

        for (int val : arr) set.add(val);

        Arrays.sort(arr); // Add this line to sort the input array

        for (int val : arr) {
            //giving each unique value a chance to be root node of the tree
            ans += solve(val, arr);
            ans %= mod;
        }

        return (int) ans;
    }

    public long solve(int val, int[] nums) {

        if (dp.containsKey(val)) {
            return dp.get(val);
        }

        long ans = 1;

        for (int i = 0; i < nums.length && nums[i] <= val / 2; i++) { // Modify loop condition to stop at val / 2
            if (val % nums[i] == 0 && set.contains(val / nums[i])) {
                long left = solve(nums[i], nums);
                long right = solve(val / nums[i], nums);

                ans += ((left * right) % mod);
                ans %= mod;
            }
        }

        dp.put(val, ans);

        return ans;
    }
}
```