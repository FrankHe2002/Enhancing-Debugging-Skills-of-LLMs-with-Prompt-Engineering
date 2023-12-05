The buggy code has the issue of incorrectly updating and storing values in the HashMap. 

In the else block, the statement `map.put(nums[i], map.getOrDefault(nums[i], 0) * 1);` should be `map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);` to correctly update the count of the current number.

The corrected code with minimal changes is as follows:

```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0) {
                count++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
```