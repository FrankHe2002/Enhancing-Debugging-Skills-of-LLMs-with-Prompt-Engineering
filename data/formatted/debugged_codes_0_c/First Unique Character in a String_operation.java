The code seems to have a bug in the last line where it returns "+ 1" instead of "-1" if there is no unique character found in the string.

To identify the bug, we can follow these steps:
1. Initialize a `HashMap` to keep track of the count of each character.
2. Iterate through the characters in the input string.
3. Check if the character is already present in the `HashMap`. If not, add it with a count of 1. If it is already present, increment the count by 1.
4. Iterate through the characters in the input string again.
5. For each character, check its count in the `HashMap`. If the count is 1, return the index of the character.
6. If no unique character is found, return -1.

To fix the bug, we need to change the last line from `return + 1;` to `return -1;`.

Here is the corrected code:

```java
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), 1);
            } else {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hmap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
```