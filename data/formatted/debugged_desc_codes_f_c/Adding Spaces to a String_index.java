The bug in the code is caused by the incorrect array indexing when accessing `spaces`. The condition `spaces[j +1]` should be just `spaces[j]` since we want to compare the current index `curr` with the value in `spaces` at index `j`. Also, the condition `j < spaces.length` should be used in the `while` loop as this is comparing if `j` is within the correct range of `spaces` before attempting to access the array at index `j`.

Fix:
```java
class Solution {
    public String addSpaces(String s, int[] spaces) {

        int j = 0, curr = 0;
        StringBuilder sb = new StringBuilder();
        while (curr < s.length()) {
            if (j < spaces.length && spaces[j] == curr) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(curr));
            curr++;
        }
        return sb.toString();
    }
}
```