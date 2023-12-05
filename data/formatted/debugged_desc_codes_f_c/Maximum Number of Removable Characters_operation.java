The bug in the provided code is the isSubsequence method's typo in the expression `wordChar * 1` which should instead be `wordChar - 1`. This typo results in an infinite loop.

Here's the fixed code:
```java
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;

        while(left < right) {
            int middle = (right + left + 1) / 2;
            String afterRemoval = remove(s, removable, middle);
            if(isSubsequence(p, afterRemoval, p.length(), afterRemoval.length()))
                left = middle;
            else
                right = middle - 1;
        }

        return left;
    }

    private String remove(String s, int[] removable, int k) {
        char[] symbols = s.toCharArray();
        for(int i = 0; i < k; i++) {
            symbols[removable[i]] = Character.MIN_VALUE;
        }
        return new String(symbols).replaceAll(Character.toString(Character.MIN_VALUE), "");
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