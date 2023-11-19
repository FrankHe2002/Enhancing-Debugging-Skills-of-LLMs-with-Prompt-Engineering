Bug Type: Off-by-One Error

Reasoning: The code subtracts 1 from `columnNumber` before calculating the corresponding character. This adjustment is likely made to handle the mapping from 1-based numbering (A=1) to 0-based numbering (A=0). However, this adjustment is unnecessary and causes an off-by-one error. The correct mapping can be achieved without subtracting 1 from `columnNumber`.

Fix:
```java
// Runtime: 1 ms (Top 36.84%) | Memory: 41.2 MB (Top 58.44+)
class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while (columnNumber > 0) {
            ans = String.valueOf((char) ('A' + (int) ((26 + (long) columnNumber) % 26))) + ans;
            columnNumber /= 26;
        }
        return ans;
    }
}
```