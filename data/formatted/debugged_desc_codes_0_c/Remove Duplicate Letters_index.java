Bug type:
Logical error - incorrect implementation for calculating lastIndex array

Reasoning:
The code is using an array called lastIndex to keep track of the last index of character presence. However, the array size is initialized to 3, which is incorrect. It should be of size 26 to cover all lowercase English letters.

Additionally, the comparison in the while loop condition may cause incorrect results. The condition should check for greater than or equal to the lastIndex.

Fix:
1. Change the lastIndex array size from 3 to 26.
2. Correct the condition in the while loop to check for greater than or equal to lastIndex.

Updated code:
```java
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        }

        boolean[] seen = new boolean[26]; // keep track seen
        Stack<Integer> st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue; // if seen continue as we need to pick one char only
            while (! st.isEmpty() && st.peek() >= curr && i < lastIndex[st.peek()]) {
                seen[st.pop()] = false; // pop out and mark unseen
            }
            st.push(curr); // add into stack
            seen[curr] = true; // mark seen
        }

        StringBuilder sb = new StringBuilder();
        while (! st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}
```