The bug type in the provided Java code is a logic error.

Explanation:
The logic in the code is flawed because while it's checking for anagrams, it's only doing it in order. A more subtle bug is that removing one or adding one then retesting will not catch cases where 3 or more words are anagrams. 

The fix is to filter the list of words to filter out duplicates and to return the distinct strings.

Fix:
```java
import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> li = new ArrayList<>(new HashSet<>(Arrays.asList(words)));
        return li;
    }
}
```