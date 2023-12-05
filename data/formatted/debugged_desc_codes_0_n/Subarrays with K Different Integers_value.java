```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int left = 0, right = 0, ans = 0;

        while (right < nums.length) {
            if (hm.getOrDefault(nums[right], 0) == 0) {
                k--;
            }
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            right++;

            while (k < 0) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            ans += right - left;
        }
        return ans;

    }
}
```