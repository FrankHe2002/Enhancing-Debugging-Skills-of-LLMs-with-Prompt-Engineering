```java
// Runtime: 3 ms (Top 63.81%) | Memory: 53.8 MB (Top 11.36%)
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) return num.substring(0, i + 1);
        }
        return "";
    }
}
```