```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i) + a;
        }

        return s.equals(a);
    }
}
```