```java
class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ", k);
        return String.join(" ", words);
    }
}
```