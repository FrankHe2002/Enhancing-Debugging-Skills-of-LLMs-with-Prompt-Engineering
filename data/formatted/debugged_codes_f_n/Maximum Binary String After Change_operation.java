Fixed Code:
```java
class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        int onesAfter1stZero = 0;
        boolean found1stZero = false;
        for (int i = 0; i < n; i++) {
            if (found1stZero) {
                if (binary.charAt(i) == '0')
                    ans.append('1');
                else
                    buffer.append('1');
            } else {
                if (binary.charAt(i) == '0') {
                    found1stZero = true;
                    buffer.append('0');
                } else
                    ans.append('1');
            }
        }

        ans.append(buffer);
        return ans.toString();
    }
}
```