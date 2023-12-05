Fix:
```java
class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                return s;
            }
        }
        return "";
    }
}
```