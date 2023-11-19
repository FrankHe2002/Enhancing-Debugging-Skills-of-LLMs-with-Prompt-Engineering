```java
// Runtime: 6 ms (Top 53.1%) | Memory: 41.50 MB (Top 23.1%)

class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray())
            set.add(ch);

        char ch = 'A';
        for (; ch <= 'Z'; ch++)
            if (set.contains(ch) && set.contains((char) ('a' + (ch - 'A'))))
                break;
        return "" + ch;
    }
}
```