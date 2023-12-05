```java
class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while (columnNumber > 0) {
            columnNumber--;
            ans = (char) ('A' + (columnNumber % 26)) + ans;
            columnNumber /= 26;
        }
        return ans;
    }
}
```