```java
// Runtime: 5 ms (Top 53.48%) | Memory: 38.6 MB (Top 89.40%)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        s = s.trim().toLowerCase();
        String a = ""; // Initialize an empty String to store the alphanumeric characters
        boolean bool = false;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                a = a + s.charAt(i); // Concatenate the alphanumeric characters
            }
        }
        if (a.length() == 1 || a.length() == 0) {
            return true;
        }
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) { // Compare the characters at corresponding positions
                return false; // If any characters don't match, return false
            }
        }

        return true; // If all characters match, return true
    }
}
```