The bug in the provided code is in the inner loop condition `str[sentence].contains(searchWord)`. This condition is attempting to access the element at the index `sentence`, which does not exist. It should be accessing `str[i]` instead to check if the current word contains the search word.

Additionally, there are some unnecessary condition checks and variables in the code that can be simplified or removed.

Fixed Code:

```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}
```