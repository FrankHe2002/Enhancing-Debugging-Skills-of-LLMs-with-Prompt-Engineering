```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        String ans = "";
        if (k >= s.length()) {
            sb.append(s);
            sb.reverse();
            return sb.toString();
        }
        for (i = 0; i <= s.length() - k; i += k * 2) {
            String str = s.substring(i, i + k);
            sb.append(str);
            sb.reverse();
            ans += sb.toString();
            sb = new StringBuilder();

            if (i + k < s.length()) {
                ans += s.substring(i + k, i + k * 2);
            } else {
                ans += s.substring(i + k);
            }
        }
        return ans;
    }
}
```