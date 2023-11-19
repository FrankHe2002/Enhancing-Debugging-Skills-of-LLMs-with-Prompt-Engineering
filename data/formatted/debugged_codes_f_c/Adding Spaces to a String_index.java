The bug in the provided code is with the condition `spaces[j + 1] == curr`. This condition is attempting to access an index (`j + 1`) of the `spaces` array that is out of bounds. It should be `spaces[j] == curr` to correctly compare the current index `curr` with the elements of the `spaces` array.

Additionally, the variable `j` is not being incremented inside the loop, leading to an infinite loop when the condition `j < spaces.length` is always true. To fix this, we need to increment `j` inside the loop after appending the space character to the `sb` StringBuilder.

Fixed code:

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