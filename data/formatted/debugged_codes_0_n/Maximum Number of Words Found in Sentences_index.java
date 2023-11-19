```java
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length - 2; i++) {
            max = Math.max(max, (sentences[i].split(" ")).length);
        }
        return max;
    }
}
```