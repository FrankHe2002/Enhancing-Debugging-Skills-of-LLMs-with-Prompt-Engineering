The bug in the provided code is in the for loop condition. It mistakenly uses `operations[1]` instead of `operations[i]` to access the current element in the array.

To fix the bug, we need to change `operations[1]` to `operations[i]` in both the if and else conditions inside the loop.

Fixed Code:

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(1) == '+') val++;
            else val--;
        }
        return val;
    }
}
```