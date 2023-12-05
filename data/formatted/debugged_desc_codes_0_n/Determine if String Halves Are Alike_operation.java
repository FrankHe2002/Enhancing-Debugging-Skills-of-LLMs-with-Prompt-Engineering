```java
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int mid = s.length() / 2;
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            count += (set.contains(s.charAt(i))) ? ((i < mid) ? 1 : -1) : 0;
        
        return count == 0;
    }
}
```