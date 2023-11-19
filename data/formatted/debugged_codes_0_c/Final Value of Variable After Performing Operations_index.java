The bug in the provided code is in the if condition inside the for loop. 

`if (operations[1].charAt(1) == '+') val++;` 

The index `1` should be `i` in order to properly iterate through the operations array. The current code is always checking the second character of the second element of the operations array. Furthermore, the condition should check for '+', not the second character of the string.

Here's the fixed code:
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++")) val++;
            else val--;
        }
        return val;
    }
}
```

In the fixed code, I changed `operations[1].charAt(1)` to `operations[i]` to check each operation in the array. Then I updated the condition to check for either "++X" or "X++" to increment `val` and any other operation to decrement `val`.