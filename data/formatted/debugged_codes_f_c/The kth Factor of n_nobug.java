The bug in the provided code is that it uses an incorrect condition in the for loop. The loop condition, `i <= n`, will result in the loop running one extra iteration, causing an `IndexOutOfBoundsException` when accessing `list.get(k - 1)` if `k` is equal to the number of factors of `n`. 

To fix this bug, the loop condition should be changed to `i < n`. This ensures that the loop iterates until `i` becomes equal to `n` without going beyond it.

Fixed Code:
```java
import java.util.ArrayList;

class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
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