There are a few issues in the provided code:

1. In the while loop, there is a missing semicolon in the `i++` statement.
2. The condition `if (groups.size() == 1)` is not handling the case that the input array contains only 1's.

Here's the revised code with the bug fixed:

```java
class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> groups = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                groups.add(count);
                groups.add(0);
                count = 0;
            }
        }
        if (count > 0) {
            groups.add(count);
        }

        int max = 0;
        for (int i = 0; i < groups.size(); i += 2) {
            max = Math.max(max, groups.get(i));
        }

        if (max == nums.length) {
            return max - 1;
        }

        return max;
    }
}
```

Now the code correctly calculates the size of the longest subarray containing only 1's and returns 0 if there are no such subarrays.