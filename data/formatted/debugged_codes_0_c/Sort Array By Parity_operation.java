Based on a quick review of the code, the bug is on line 10. The condition `if (nums[i] * 2 == 1)` is incorrect for checking if a number is odd. Instead, it should check if the number is odd by using the modulus operator (`nums[i] % 2 == 1`) or the bitwise AND operator (`nums[i] & 1 == 1`).

To fix the bug, replace line 10 with `if (nums[i] % 2 == 1)`. 

Here's the corrected code:

```java
// Runtime: 1 ms (Top 100.00%) | Memory: 48.1 MB (Top 66.96%)
class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] % 2 == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }

        return nums;
    }
}
```