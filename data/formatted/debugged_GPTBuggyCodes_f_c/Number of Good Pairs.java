Bug Type: Infinite Loop

Explanation: The bug in the provided code is a subtle error in the loop condition of the outer loop. Instead of incrementing `i`, it is being decremented (`i--`). This leads to an infinite loop because `i` will never reach the upper limit (`i < len`) and keeps decrementing indefinitely. As a result, the program gets stuck in the outer loop and never progresses.

Fix: Change `i--` to `i++` in the outer loop to increment `i` instead of decrementing it. This will allow the loop to iterate through all the elements of the array as intended.

Fixed Code:
```java
// Runtime: 1 ms (Top 85.5%) | Memory: 40.27 MB (Top 18.8%)

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int counter = 0;
        for (int i = 0; i < len; i++) { // fix: change i-- to i++
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
```
