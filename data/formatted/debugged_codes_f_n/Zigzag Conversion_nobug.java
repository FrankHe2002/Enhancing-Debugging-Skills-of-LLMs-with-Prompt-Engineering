```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int ind = i;
            boolean up = true;
            while (ind < s.length()) {
                builder.append(s.charAt(ind));
                if (i == 0 || i == numRows - 1) {
                    ind += 2 * (numRows - 1);
                } else {
                    ind += up ? 2 * (numRows - i - 1) : 2 * i;
                    up = ! up;
                }
            }
        }
        return builder.toString();
    }
}
```