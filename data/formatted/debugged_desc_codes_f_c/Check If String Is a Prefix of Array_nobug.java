```java
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder res = new StringBuilder("");
        for (String word : words) {
            res.append(word);
            if (s.equals(res.toString()))
                return true;
            if (!s.startsWith(res.toString()))
                return false;
        }
        return false;
    }
}
```