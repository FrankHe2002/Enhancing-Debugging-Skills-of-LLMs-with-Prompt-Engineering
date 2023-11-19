The bug in the provided code is that there is a missing opening and closing curly brace for the second for loop. As a result, the code will fail to compile. 

To identify the bug, we can look for syntactical errors in the code. In this case, we can see that there are multiple closing curly braces without an opening curly brace before them, which indicates that a brace is missing.

To fix the bug, we need to add the missing opening curly brace before the line `if (index != - 1) ans[i] = Math.min(ans[i], index - i);` in the second for loop.

Here is the corrected code:

```java
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int index = - 1;
        int[] ans = new int[n];
        
        // Starting from index 0 and storing the distance from the next c;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i; //to store the index of the nearest previous c
            }

            if (index == - 1) {
                ans[i] = Integer.MAX_VALUE;
            } else {
                ans[i] = i - index;
            }
        }

        // Starting from the end and storing the distance from the previous c;
        index = - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i; //to store the index of the nearest next c
            }

            if (index != - 1) {
                ans[i] = Math.min(ans[i], index - i);
            }
        }
        
        return ans;
    }
}
```