```java
class Solution {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++) {
                    str.append(temp);
                }
                if (str.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
```