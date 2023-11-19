The bug in the provided Java code is that it does not properly handle the case when the password contains repeating characters. This is because the code immediately returns false when it encounters a repeating character, without checking the other conditions.

To fix this bug, we need to modify the condition that checks for repeating characters. Instead of returning false immediately, we should keep track of the repeating characters and return false only if the repeating characters break the other password requirements.

Here is the modified code with the bug fix:

```java
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        HashSet<Integer> intAscii = new HashSet<>();
        String specialCharacters = "!@#$%^&*()-+";
        for (int i = 0; i < specialCharacters.length(); i++) {
            int ascii = specialCharacters.charAt(i);
            intAscii.add(ascii);
        }

        if (password.length() < 8) {
            return false;
        }
        boolean small = false;
        boolean large = false;
        boolean numbers = false;
        boolean specialChars = false;
        int repeatCount = 0; // variable to track the repeat count
        for (int i = 0; i < password.length(); i++) {
            int ascii = (int) (password.charAt(i));
            if (ascii < 90 && ascii >= 65) {
                large = true;
            }
            if (ascii <= 122 && ascii >= 97) {
                small = true;
            }
            if (ascii <= 57 && ascii >= 48) {
                numbers = true;
            }
            if (intAscii.contains(ascii)) {
                specialChars = true;
            }
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                repeatCount++;
            } else {
                repeatCount = 1; // reset the repeat count if the characters are not repeating
            }
            if (repeatCount >= 3) {
                return false;
            }
        }
        if (large == false || small == false || numbers == false || specialChars == false) {
            return false;
        }
        return true;
    }
}
```