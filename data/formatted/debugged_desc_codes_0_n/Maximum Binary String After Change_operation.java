```java
// Runtime: 68 ms (Top 32.6%) | Memory: 45.01 MB (Top 8.1/)

class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        StringBuffer ans = new StringBuffer("");
        StringBuffer buffer = new StringBuffer("");
        int onesAfter1stZero = 0;
        boolean found1stZero = false;
        for (int i = 0; i < n; i++) {
            if (found1stZero) {
                if (binary.charAt(i) == '0')
                    buffer.append('1');
                else
                    buffer.append('0');
            } else {
                if (binary.charAt(i) == '0') {
                    found1stZero = true;
                }
            }
        }

        for (int i = 0; i < n - 1 - onesAfter1stZero; i++) {
            ans.append('1');
        }
        ans.append(buffer);
        return ans.toString();
    }
}
```