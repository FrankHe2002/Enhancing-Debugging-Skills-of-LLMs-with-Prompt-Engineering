The bug in the code is the incorrect placement of the closing bracket for the second for loop. This causes a syntax error and prevents the code from compiling. The logic for finding the distance to the closest occurrence of character c in the string seems correct.

Here's the corrected code:

```java
// Runtime: 2 ms (Top 72.97%) | Memory: 43.3 MB (Top 45.95%)
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int index = - 1;
        int[] ans = new int[n];
        // Starting from index 0 and storing the distance from the next c;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i; // to store the index of the nearest previous c
            }
            if (index == -1) {
                ans[i] = Integer.MAX_VALUE;
            } else {
                ans[i] = i - index;
            }
        }

        // Starting from the end and storing the distance from the previous c;
        index = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i; // to store the index of the nearest next c
            }
            if (index != -1) {
                ans[i] = Math.min(ans[i], index - i);
            }
        }
        return ans;
    }
}
```