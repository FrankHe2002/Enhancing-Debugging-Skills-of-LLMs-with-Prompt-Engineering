```java
class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> hset = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (hset.contains(ch))
                return ch;
            hset.add(ch);
        }
        return ' ';
    }
}
```