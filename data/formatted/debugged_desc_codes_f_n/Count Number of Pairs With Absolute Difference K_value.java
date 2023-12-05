```java
// Runtime: 9 ms (Top 51.83%) | Memory: 44.1 MB (Top 44.46%)
class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += map.getOrDefault(nums[i] - k, 0);
            res += map.getOrDefault(nums[i] + k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return res;
    }
}
```