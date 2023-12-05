The bug in the code is in the for loop condition. The loop will not run because the condition `i > repeat + 2` will always be false. The loop should run while `i` is less than or equal to `repeat + 2`.

To fix this issue, the condition in the for loop should be changed to `i <= repeat + 2`.

Here is the corrected code:

```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        String copyA = a;
        int count = 1;
        int repeat = b.length() / a.length();
        for (int i = 0; i <= repeat + 2; i++) {
            if (a.contains(b)) {
                return count;
            } else {
                a += copyA;
                count++;
            }
        }
        return -1;
    }
}
```