```java
// Runtime: 2 ms (Top 90.61%) | Memory: 39.7 MB (Top 82.47%)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return (String.join("", word1).equals(String.join("", word2)));
    }
}
```