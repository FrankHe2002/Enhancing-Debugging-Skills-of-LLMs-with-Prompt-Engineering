Bug Type: String Replacement Issue

Reasoning: The provided code attempts to remove all occurrences of a given substring `part` from the string `s`. However, the code utilizes the `replaceFirst` method, which only replaces the first occurrence of the given substring. Therefore, the code does not remove all occurrences of `part` from `s` correctly.

Fix:
The fix is to replace the `replaceFirst` method with the `replaceAll` method, which replaces all occurrences of the given substring. This change will ensure that all instances of `part` are removed from `s` correctly.

Fixed Code:
```java
class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceAll(part, "");
        }
        return s;
    }
}
```