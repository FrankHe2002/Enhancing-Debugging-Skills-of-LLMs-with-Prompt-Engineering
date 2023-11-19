The bug in the provided Java code is in the recursive call in the `isSubsequence` method, specifically in the line where `wordChar` is multiplied by 1:

```java
return isSubsequence(subSequence, word, subSequenceChar - 1, wordChar * 1);
```

This multiplication is unnecessary and causes the value of `wordChar` to increase in each recursive call instead of decreasing. This means that the recursion will not terminate correctly, leading to incorrect results.

To fix the bug, we need to remove the multiplication by 1 and change the line to:

```java
return isSubsequence(subSequence, word, subSequenceChar - 1, wordChar - 1);
```

This change ensures that `wordChar` is correctly decremented in each recursive call, allowing the recursion to terminate when either `subSequenceChar` or `wordChar` reaches 0.

Here is the fixed code:

```java
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;

        while (left < right) {
            int middle = (right + left + 1) / 2;
            String afterRemoval = remove(s, removable, middle);
            if (isSubsequence(p, afterRemoval, p.length(), afterRemoval.length()))
                left = middle;
            else
                right = middle - 1;
        }

        return left;
    }

    private String remove(String s, int[] removable, int k) {
        char[] symbols = s.toCharArray();
        for (int i = 0; i < k; i++) {
            symbols[removable[i]] = Character.MIN_VALUE;
        }
        return String.valueOf(symbols);
    }

    private boolean isSubsequence(String subSequence, String word, int subSequenceChar, int wordChar) {
        if (subSequenceChar == 0) return true;
        if (wordChar == 0) return false;

        if (subSequence.charAt(subSequenceChar - 1) == word.charAt(wordChar - 1))
            return isSubsequence(subSequence, word, subSequenceChar - 1, wordChar - 1);

        return isSubsequence(subSequence, word, subSequenceChar, wordChar - 1);
    }
}
```