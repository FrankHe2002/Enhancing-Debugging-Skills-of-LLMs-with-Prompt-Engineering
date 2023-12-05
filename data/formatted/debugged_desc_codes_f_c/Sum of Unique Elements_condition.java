Bug type: Logical error
The bug here is that the loop condition is incorrect and should be `i < nums.length`. Additionally, when an element from the array is checked for uniqueness, the sum of the unique elements needs to be incremented or decremented based on its frequency in the array.

Fix:
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