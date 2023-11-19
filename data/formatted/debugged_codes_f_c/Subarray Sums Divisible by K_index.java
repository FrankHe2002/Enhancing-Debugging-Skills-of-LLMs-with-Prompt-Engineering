Bug Type: ArrayIndexOutOfBoundsException

Reasoning: In the for loop, the code attempts to access the element in the `nums` array using the index `-1` (`sum += nums[-1];`). Array indices in Java start from 0, so the index `-1` is out of bounds. This results in an `ArrayIndexOutOfBoundsException`. 

Fix: Change `sum += nums[-1];` to `sum += nums[i];` to correctly access the current element in the loop.

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
                rem = rem + k; // -4%3 == -1 and 2 both bec -4 = 3(-1) +(-1) = 3(-2) + 2
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