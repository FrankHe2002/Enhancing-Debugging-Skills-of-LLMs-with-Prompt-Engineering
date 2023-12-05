Explanation:
There are several issues in the `longestSubarray` method:
1. The code uses an ArrayList and adds elements based on conditions that don't align with the requirements.
2. Index management inside the while loop is missing `+=` operator and semi colon.
3. The logic to compute max is faulty.

Fix:
```java
class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> groups = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
            else {
                groups.add(count);
                count = 0;
            }
        }
        groups.add(0);  // Adding this to handle the case where 1's are at the end
        int max = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (i < groups.size() - 1) {
                max = Math.max(max, groups.get(i));
            } else {
                max = Math.max(max, groups.get(i - 1) + groups.get(i + 1));
            }
        }
        return max;
    }
}
```