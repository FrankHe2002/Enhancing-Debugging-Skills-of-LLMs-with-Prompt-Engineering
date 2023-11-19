Bug Type: Semantic Error

Reasoning: 

1. The condition `arr.length != 0` in the `if` statement on line 3 is incorrect. It should be `arr.length == 0` to check if the array is empty. 

2. The initial value assigned to `size` and `res` on lines 7 and 8 should be a large number, rather than `arr.length + 1`. It is also mentioned that using `MAX_VALUE` may cause an overflow issue on line 10.

Fix:

1. Change the condition in the `if` statement on line 3 to `arr.length == 0`.

2. Change the initial value of `size` and `res` on lines 7 and 8 to a large number (`Integer.MAX_VALUE`).

Fixed Code:
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); //sum - index
        map.put(0, - 1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { //record preSum and index
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int size = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target))
                size = Math.min(size, i - map.get(sum - target)); //find the subarray from the previous index to current one
            if (map.containsKey(sum + target))
                res = Math.min(res, size + map.get(sum + target) - i); //from the current index to next one, this avoid overlap
        }
        return res == arr.length + 1 ? - 1 : res;
    }
}
```
