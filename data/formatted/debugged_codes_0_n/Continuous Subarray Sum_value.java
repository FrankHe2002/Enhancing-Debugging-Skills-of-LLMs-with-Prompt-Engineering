```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(-1, - 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = k == 0 ? sum : sum % k;
            if (h.containsKey(sum) && i - h.get(sum) >= 2) {
                return true;
            }
            h.put(sum, h.getOrDefault(sum, i));
        }
        return false;
    }
}
```