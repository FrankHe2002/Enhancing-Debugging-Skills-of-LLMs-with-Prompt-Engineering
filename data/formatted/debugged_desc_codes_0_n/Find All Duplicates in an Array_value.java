```java
// Runtime: 13 ms (Top 42.32%) | Memory: 66.5 MB (Top 5.90%)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[ind] = -nums[ind];
            }
        }
        return ans;
    }
}
```