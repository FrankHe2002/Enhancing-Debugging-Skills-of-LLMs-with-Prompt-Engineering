Bug Type: ArrayIndexOutOfBoundsException

Reasoning: 
The loop condition is `i <= nums.length`, which attempts to access an index out of the array's bounds. In Java, array indices range from 0 to `length - 1`. The loop should iterate only within the array's valid range, so the condition for the loop should be `i < nums.length`.

Fix:
Change the loop condition from `i <= nums.length` to `i < nums.length`.

Fixed Code:
```java
// Runtime: 1 ms (Top 86.10%) | Memory: 40.1 MB (Top 92.63%)
class Solution {
    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1) res += nums[i];
            else if (map.get(nums[i]) == 2) res -= nums[i];
        }
        return res;
    }
}
```