```java
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i])) continue;
            int count = countMap.get(nums[i]);
            if (count == 1) countMap.remove(nums[i]);
            else countMap.put(nums[i], count - 1);
            for (int j = 1; j < k; j++) {
                int next = nums[i] + j;
                if (!countMap.containsKey(next)) return false;
                count = countMap.get(next);
                if (count == 1) countMap.remove(next);
                else countMap.put(next, count - 1);
            }
        }
        return true;
    }
}
```