The provided code seems to have a bug. 

The variable `len` is initialized to 2, and then updated whenever the size of the set `set` reaches `k`. However, the variable `len` is also incremented by 1 before returning it in the last line. This means that the final result will always be 1 more than the actual length of the shortest sequence.

To fix this bug, we need to subtract 1 from the value returned in the last line.

Here is the corrected code:

```java
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int len = 2;
        Set<Integer> set = new HashSet<>();
        for (int i : rolls) {
            set.add(i);
            if (set.size() == k) {
                set = new HashSet<>();
                len++;
            }
        }
        return len - 1;
    }
}
```