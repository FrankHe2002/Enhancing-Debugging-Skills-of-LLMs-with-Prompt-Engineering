```java
// Runtime: 9 ms (Top 62.33%) | Memory: 67.5 MB (Top 39.21%)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int indx = Math.abs(nums[i]) - 1;
            if (nums[indx] > 0) {
                nums[indx] = nums[indx] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
```