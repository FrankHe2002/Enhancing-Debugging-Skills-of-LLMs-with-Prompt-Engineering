```java
// Runtime: 9 ms (Top 38.9%) | Memory: 43.67 MB (Top 34.2%)

class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
```