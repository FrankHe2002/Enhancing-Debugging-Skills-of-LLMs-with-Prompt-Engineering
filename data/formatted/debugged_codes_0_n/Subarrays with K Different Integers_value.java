```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    public int count(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int left = 0, right = 0, ans = 0;

        while (right < nums.length) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            right++;

            while (hm.size() > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0)
                    hm.remove(nums[left]);
                left++;
            }
            ans += right - left;
        }
        return ans;

    }
}
```