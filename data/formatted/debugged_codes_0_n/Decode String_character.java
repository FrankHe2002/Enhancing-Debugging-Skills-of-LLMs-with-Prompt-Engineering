```java
class Solution {
    public String decodeString(String s) {

        int bb = s.indexOf('[');
        int nbb = s.indexOf('[', bb + 1);
        int eb = s.indexOf(']');

        int n = 0;
        int nl = 1;
        char nd;

        String insert = "";
        String end = "";

        while (bb != - 1) {

            while (nbb < eb && nbb > bb) {
                bb = nbb;
                nbb = s.indexOf('[', bb + 1);
            }

            nl = 1;
            while (bb - nl >= 0) {
                nd = s.charAt(bb - nl);
                if (nd <= '9' && nd >= '0') {
                    n += (int) (nd - '0') * Math.pow(10, nl - 1);
                    nl++;
                } else break;
            }

            insert = s.substring(bb + 1, eb);
            end = s.substring(eb + 1);
            s = s.substring(0, bb - nl + 1);

            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append(insert);
                n--;
            }
            s += sb.toString();
            s += end;

            bb = s.indexOf('[');
            nbb = s.indexOf('[', bb + 1);
            eb = s.indexOf(']');
        }
        return s;
    }
}
```