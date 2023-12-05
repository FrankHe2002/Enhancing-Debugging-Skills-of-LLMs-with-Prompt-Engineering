```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int cnt = 1, i = 0;
        StringBuilder sb = new StringBuilder();
        String ans = "";
        if (k >= s.length()) {
            sb.append(s);
            sb.reverse();
            return sb.toString();
        }
        for (i = 0; i < s.length(); i += 2 * k) {
            if (i + k <= s.length()) {
                String str = s.substring(i, i + k);
                sb.append(str);
                sb.reverse();
                ans += sb.toString();
                sb = new StringBuilder();
                if (i + 2 * k > s.length()) {
                    ans += s.substring(i + k, s.length());
                    break;
                }
                String rest = s.substring(i + k, i + 2 * k);
                ans += rest;
            } else {
                sb.append(s.substring(i, s.length()));
                sb.reverse();
                ans += sb.toString();
            }
        }
        return ans;
    }
}
```