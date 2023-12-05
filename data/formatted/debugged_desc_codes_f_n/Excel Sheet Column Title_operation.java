```java
// Runtime: 1 ms (Top 36.84%) | Memory: 41.2 MB (Top 58.44+)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            ans.insert(0, (char) ('A' + (int) ((26 + (long) columnNumber) % 26)));
            columnNumber /= 26;
        }
        return ans.toString();
    }
}
```