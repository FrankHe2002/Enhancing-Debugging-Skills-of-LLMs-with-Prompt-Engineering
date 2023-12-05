```java
// Runtime: 1 ms (Top 88.88%) | Memory: 41.8 MB (Top 72.85%)
class Solution {
    public String decodeString(String s) {

        int ind = 0;
        StringBuilder result = new StringBuilder();

        while (ind < s.length()) {
            if (Character.isDigit(s.charAt(ind))) {
                int count = 0;
                while (Character.isDigit(s.charAt(ind))) {
                    count = count * 10 + (s.charAt(ind) - '0');
                    ind++;
                }
                ind++; // to skip '['
                int open = 1, close = 0;
                for (int i = ind; i < s.length(); i++) {
                    if (s.charAt(i) == '[') open++;
                    else if (s.charAt(i) == ']') close++;
                    if (open == close) {
                        String subStr = s.substring(ind, i);
                        String recursion = decodeString(subStr);
                        for (int j = 0; j < count; j++) {
                            result.append(recursion);
                        }
                        ind = i + 1;
                        break;
                    }
                }
            } else {
                result.append(s.charAt(ind));
                ind++;
            }
        }
        return result.toString();
    }
}
```