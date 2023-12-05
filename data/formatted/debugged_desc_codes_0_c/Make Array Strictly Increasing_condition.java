The bug in the provided code is likely due to a typographical error in the second for loop condition. The condition `i > B.length` is incorrect and will result in the loop not being executed. The correct condition should be `i < B.length` in order to loop through all elements of the array.

Besides this, there are no other logic errors, and the functionality of the code seems to be appropriate.

Let's correct the bug by updating the condition in the for loop.

Here's the corrected code:

```java
import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int makeArrayIncreasing(int[] A, int[] B) { // A = arr1, B = arr2
        TreeSet<Integer> set = new TreeSet<>(Arrays.stream(B).boxed().toList());
        int[] dp = new int[B.length + 1];
        dp[0] = - 1;
        int INF = (int) 2e9;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length; j >= 0; j--) {
                int a = A[i] > dp[j] ? A[i] : INF; // option A - don't swap
                Integer b = set.higher(j == 0 ? INF : dp[j - 1]); // option B - swap
                dp[j] = Math.min(a, b == null ? INF : b); // take the min of A and B
            }
        }
        for (int i = 0; i < B.length; i++) { // Corrected loop condition
            if (dp[i] != INF) {
                return i;
            }
        }
        return - 1;
    }
}
```

The only change made is to update the condition in the for loop to `i < B.length`.