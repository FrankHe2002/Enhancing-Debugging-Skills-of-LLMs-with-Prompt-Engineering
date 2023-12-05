Explanation:
The issue in the `checkIfPangram` method lies in bitwise manipulation and the handling of characters. The code does not correctly track the appearance of letters and does not set the correct bits for each letter. Fixing this issue involves using the correct bitwise operation to set the appropriate bit for each letter. Additionally, the implementation of the bitwise OR operation between `seen` and the bit representing the current character isn't appropriate.

Fix:
```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        for (char c : sentence.toCharArray()) {
            int ci = c - 'a';
            seen = seen | (1 << ci);
        }
        return seen == ((1 << 26) - 1);
    }
}
```