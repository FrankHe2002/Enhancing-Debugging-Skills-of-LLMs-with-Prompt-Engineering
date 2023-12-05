Bug type: Array index out of bounds

Reasoning:
1. The code iterates through the flips array using a for loop with a condition i < flips.length. 
2. Inside the loop, the code accesses flips[i+1] without checking if i+1 is within the bounds of the array, which can cause an ArrayIndexOutOfBoundsException.

Fix:
- Adjust the loop condition to i < flips.length - 1, to ensure that the index flips[i+1] is within the bounds of the array.
- Change the condition inside the loop to check if max < flips[i] instead of max < flips[i+1].
- Decrement the max variable by 1.

The corrected code:
```java
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int counter = 0, total = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < flips.length - 1; i++) {
            if (max < flips[i]) max = flips[i];
            if (++counter == max) total++;
        }
        return total;
    }
}
```