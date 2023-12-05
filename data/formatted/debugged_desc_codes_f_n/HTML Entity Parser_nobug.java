Fix:
```java
// Runtime: 34 ms (Top 96.2%) | Memory: 52.6 MB (Top 97.5%)
class Solution {
    public String entityParser(String text) {
        return text.replace("&quot;", "\"").replace("&apos;", "'").replace("&gt;", ">").replace("&lt;", "<").replace("&frasl;", "/").replace("&amp;", "&").replaceAll("&amp;", "&");
    }
}
```