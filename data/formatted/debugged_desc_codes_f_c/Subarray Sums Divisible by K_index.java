The bug in the provided Java code is in the `subarraysDivByK` method. There are several issues:
1. Sum calculation: `sum += nums[-1];` should be `sum += nums[i];` to calculate the sum of the subarray.
2. Loop condition: The loop condition 'i < nums.length' should be changed based on the actual input parameters.
3. HashMap key: The `HashMap` key calculation formula to compute 'rem' is incorrect. It should extract the sum before the current index from the current sum and then calculate `rem`.
4. Incorrect handling of negative remainder: The check for negative remainder is incorrect.

The fixed code is as follows:

```java
import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k; // Handle negative remainder correctly
            }

            if (rem == 0) {
                count++;
            }
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
```