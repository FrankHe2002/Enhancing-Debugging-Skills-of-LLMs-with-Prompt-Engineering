```java
class Solution {
    public String reformat(String s) {

        List<Character> ch = new ArrayList<>();
        List<Character> d = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') ch.add(c);
            else d.add(c);
        }

        if (Math.abs(d.size() - ch.size()) > 1) return ""; // change / to -

        StringBuilder str = new StringBuilder();

        while (!ch.isEmpty() || !d.isEmpty()) { // delete the for loop

            if (ch.size() > d.size())
                str.append(appender(ch, d));
            else
                str.append(appender(d, ch));
        }
        
        return new String(str);

    }

    public String appender(List<Character> first, List<Character> second) {

        StringBuilder str = new StringBuilder();

        if (!first.isEmpty()) {
            str.append(first.get(0));
            first.remove(0);
        }
        if (!second.isEmpty()) {
            str.append(second.get(0));
            second.remove(0);
        }

        return new String(str);
    }
}
```