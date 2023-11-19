Bug Type: Infinite Loop

Reasoning:
1. The inner for loop iterates over indices `j` that are greater than `i`. 
2. The outer for loop starts at index `i` and decrements `i` with each iteration.
3. Since `i` is decremented and never incremented, it will eventually reach a negative value and the loop will continue indefinitely.

Fix:
Change `i--` to `i++` in the outer for loop.

```java
// Runtime: 1 ms (Top 85.5%) | Memory: 40.27 MB (Top 18.8%)

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int counter = 0;
        for (int i = 0; i < len; i++) {
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