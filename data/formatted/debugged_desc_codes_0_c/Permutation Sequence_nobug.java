The bug in the given code is the for loop condition where "i" is checked for whether it is less than "n" as it should be less than or equal to "n". The "i" begins with a value of 1 and the loop terminates before reaching the value of "n". Therefore, the last number in the permutation is missing.

To fix this bug, the condition in the for loop should be changed from "i < n" to "i <= n".

Here's the corrected code in markdown format:

```java
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        String res = "";
        k = k - 1; // We use 0 indexing.
        while (true) {
            fact = fact / nums.size();
            res = res + nums.remove(k / fact);
            if (nums.size() == 0) break;
            k = k % fact;
        }
        return res;
    }
}
```