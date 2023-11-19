Bug Type: Syntax Error (Missing closing parenthesis in method declaration)

Reasoning: Upon reviewing the provided code, it can be observed that the method declaration for `findMiddleIndex` is missing the closing parenthesis `)` after the `nums` parameter. This syntax error causes a compilation error.

Fix:
```java
// Runtime: 2 ms (Top 16.64%) | Memory: 42.4 MB (Top 52.37%)

class Solution {
    public int findMiddleIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int rsum = 0;
            int lsum = 0;

            for (int k = 0; k < i; k++) lsum += nums[k];
            for (int k = i + 1; k < nums.length; k++) rsum += nums[k];

            if (lsum == rsum) {
                return i;
            }
        }

        return - 1;

    }
}
```