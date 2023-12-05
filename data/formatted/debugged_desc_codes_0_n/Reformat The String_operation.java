```java
class Solution {
    public String reformat(String s) {

        List<Character> ch = new ArrayList<>();
        List<Character> d = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') ch.add(c);
            else d.add(c);
        }

        if (Math.abs(d.size() - ch.size()) > 1) return "";

        StringBuilder str = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < ch.size() && j < d.size()) {
            if (ch.size() > d.size())
                str.append(ch.get(i++));
                str.append(d.get(j++));
            } else {
                str.append(d.get(j++));
                str.append(ch.get(i++));
            }
        }

        while (i < ch.size()) {
            str.append(ch.get(i++));
        }

        while (j < d.size()) {
            str.append(d.get(j++));
        }

        return new String(str);

    }
    public String appender(List<Character> first, List<Character> second) {

        StringBuilder str = new StringBuilder();

        if (! first.isEmpty()) {
            str.append(first.get(0));
            first.remove(0);
        }
        if (! second.isEmpty()) {
            str.append(second.get(0));
            second.remove(0);
        }

        return new String(str);
    }
}
```