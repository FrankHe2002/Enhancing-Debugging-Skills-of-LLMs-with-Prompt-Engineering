Fixed Code:

```java
// Runtime: 7 ms (Top 78.0%) | Memory: 39.50 MB (Top 69.1%)

class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(part);
        while (index != -1) {
            sb.delete(index, index + part.length());
            index = sb.indexOf(part);
        }
        return sb.toString();
    }
}
```