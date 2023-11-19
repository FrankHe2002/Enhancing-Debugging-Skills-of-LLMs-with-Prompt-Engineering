The bug in the provided code is in the second if condition inside the for loop. It incorrectly checks if `closest_num < n` to update `closest_num` when `min` is equal to `Math.abs(n)`. The correct condition should be `closest_num > n`.

Fixing the bug by changing the condition from `closest_num < n` to `closest_num > n` will ensure that `closest_num` is updated with the bigger value if `min` is equal to `Math.abs(n)`.

Fixed Code:
```java
// If absolute of n is less than min, update the closest_num 
// If absolute of n is same as min, update the bigger closest_num

class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE, closest_num = 0;
        for (int n : nums) {
            if (min > Math.abs(n)) {
                min = Math.abs(n);
                closest_num = n;
            } else if (min == Math.abs(n) && closest_num > n) {
                closest_num = n;
            }
        }
        return closest_num;
    }
}
```