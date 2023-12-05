## Code Description:

You are given two strings `word1` and `word2`. You want to construct a string `merge` in the following way: while either `word1` or `word2` are non-empty, choose one of the following options:

- If `word1` is non-empty, append the first character in `word1` to `merge` and delete it from `word1`.
- If `word2` is non-empty, append the first character in `word2` to `merge` and delete it from `word2`.

Return the lexicographically largest merge you can construct.

A string `a` is lexicographically larger than a string `b` (of the same length) if in the first position where `a` and `b` differ, `a` has a character strictly larger than the corresponding character in `b`.

Constraints:
- 1 <= `word1.length`, `word2.length` <= 3000
- `word1` and `word2` consist only of lowercase English letters.

## Code:

```java
class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int n1 = w1.length;
        int n2 = w2.length;

        while (i < n1 && j < n2) {
            if (w1[i] == w2[j]) {
                if (check(w1, i, w2, j)) {
                    sb.append(w1[i++]);
                } else {
                    sb.append(w2[j++]);
                }
            } else if (w1[i] > w2[j]) {
                sb.append(w1[i++]);
            } else {
                sb.append(w2[j++]);
            }
        }

        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }

    private boolean check(char[] w1, int i, char[] w2, int j) {
        while (i < w1.length && j < w2.length) {
            if (w1[i] == w2[j]) {
                i++;
                j++;
            } else if (w1[i] > w2[j]) {
                return true;
            } else {
                return false;
            }
        }

        if (i < w1.length) {
            return true;
        }
        return false;
    }
}
```