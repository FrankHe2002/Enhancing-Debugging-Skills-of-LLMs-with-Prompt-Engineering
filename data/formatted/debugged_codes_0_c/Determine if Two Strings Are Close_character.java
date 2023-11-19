The bug in the provided Java code is that the arrays `arr1` and `arr2` are not being sorted correctly before comparing them.

To fix this bug, we can add the line `Arrays.sort(arr1);` after counting the occurrences of each letter in `word1`, and add the line `Arrays.sort(arr2);` after counting the occurrences of each letter in `word2`. This will ensure that the arrays are sorted in ascending order before comparing them.

Here's the fixed code:

```java
class Solution {
    private int N = 26;

    public boolean closeStrings(String word1, String word2) {
        // count the English letters
        int[] arr1 = new int[N], arr2 = new int[N];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // if one has a letter which another one doesn't have, dont exist
        for (int i = 0; i < N; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            if (arr1[i] == 0 || arr2[i] == 0) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
```

By sorting the arrays `arr1` and `arr2` before comparing them, we can correctly check if the letter frequencies are the same and if there are no additional letters in one word that don't exist in the other word.