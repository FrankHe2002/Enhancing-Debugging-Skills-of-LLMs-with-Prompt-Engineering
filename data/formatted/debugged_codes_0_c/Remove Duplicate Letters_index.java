Bug type: ArrayIndexOutOfBoundsException

Reasoning:
1. The code initializes the `lastIndex` array with size 3, but there are 26 characters in the English alphabet. This can cause an ArrayIndexOutOfBoundsException when trying to access indices greater than 2.

Fix:
1. Change the size of the `lastIndex` array from 3 to 26 to accommodate all the characters in the English alphabet.

Updated code:
```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // fix: change size to 26
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        }

        boolean[] seen = new boolean[26]; // keep track seen
        Stack<Integer> st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue; // if seen continue as we need to pick one char only
            while (! st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]) {
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