```java
class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        char ch; // declare 'ch' outside of the loop

        for (ch : s.toCharArray())
            set.add(ch);

        for (ch = 'Z'; ch >= 'A'; ch--)
            if (set.contains(ch) && set.contains((char) ('a' + (ch - 'A'))))
                return "" + ch;
        return ""; // return empty string if no character is found
    }
}
```