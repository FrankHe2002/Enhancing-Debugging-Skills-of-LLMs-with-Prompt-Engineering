Fix:
```java
class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            String reverse = "";
            for(int i = s.length() - 1; i >= 0; i--) {
                reverse = reverse + s.charAt(i);
            }
            if (s.equals(reverse)) {
                return s;
            }
        }
        return "";
    }
}
```