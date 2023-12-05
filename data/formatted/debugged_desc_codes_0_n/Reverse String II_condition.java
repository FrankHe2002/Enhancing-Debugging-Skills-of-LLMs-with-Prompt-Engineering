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
            String str = i + k < s.length() ? s.substring(i, i + k) : s.substring(i);
            if (cnt % 2 != 0) {
                sb.append(str);
                sb.reverse();
                ans += sb.toString();
                cnt++;
                sb = new StringBuilder();
            } else {
                ans += str;
                cnt++;
            }
        }
        return ans;
    }
}
```