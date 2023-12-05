```java
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        if (s.equals(goal)) {
            HashSet<Character> hset = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (!hset.contains(s.charAt(i))) {
                    hset.add(s.charAt(i));
                } else {
                    return true;
                }
            }
            return false;
        } else {
            char a = '\u0000', b = '\u0000';
            char c = '\u0000', d = '\u0000';
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (a == '\u0000') {
                        a = s.charAt(i);
                        c = goal.charAt(i);
                    } else if (b == '\u0000') {
                        b = s.charAt(i);
                        d = goal.charAt(i);
                    } else {
                        return false;
                    }
                }
            }
            return (a == d && b == c && a != '\u0000');
        }
    }
}
```