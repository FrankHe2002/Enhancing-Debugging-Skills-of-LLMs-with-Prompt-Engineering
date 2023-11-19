Bug type: Syntax Error (Missing Parenthesis)

Reasoning: The code has a syntax error due to a missing parenthesis in the "for" loop declaration. The line `for int i = 0; i < nums.length; i++)` is missing an opening parenthesis `(` after the keyword "for".

Fix:
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ind++] = nums[i];
            }
        }
        return ind;
    }
}
```