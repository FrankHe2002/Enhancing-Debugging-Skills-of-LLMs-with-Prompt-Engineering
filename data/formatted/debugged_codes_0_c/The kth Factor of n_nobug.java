The bug in the provided code is that it does not handle the case when there are not enough factors of n to satisfy the value of k. In such cases, the code returns -1. However, the bug is that the code should return -1 when there are fewer factors than k, not when there are fewer factors than n.

To fix this bug, we need to change the condition in line 11 to check if the size of list is less than k instead of checking if it is less than n.

Here is the updated code with the fix:
```java
import java.util.ArrayList;

class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                list.add(i);
            }
        }
        if (list.size() < k) {
            return -1;
        }

        return list.get(k - 1);
    }
}
```
The fix is made by changing the condition in line 11 from `if (list.size() < n)` to `if (list.size() < k)`.