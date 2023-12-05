The provided buggy Java code can be fixed by modifying a few parts in the code:

1. Change the condition in the for loop to iterate over `sorted` instead of `nums`.
2. To handle the case of duplicates, get the index of the first occurrence of a number rather than just the count of smaller numbers.
3. Update the way to initialize the `sorted` array through sorting it.

Here is the fixed code for the given problem:

```java
import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, (i, j) -> nums[i] - nums[j]);
        int[] ret = new int[n];
        ret[sorted[0]] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[sorted[i]] == nums[sorted[i - 1]]) {
                ret[sorted[i]] = ret[sorted[i - 1]];
            } else {
                ret[sorted[i]] = i;
            }
        }
        return ret;
    }
}
```

Testing the fixed code with a few test cases ensures that it produces the correct results and avoids potential bugs.