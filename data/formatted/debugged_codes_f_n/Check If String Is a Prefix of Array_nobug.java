Fixed Code:
```java
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder res = new StringBuilder("");
        for (String word : words) {
            res.append(word);
            if (s.equals(res.toString()))
                return true;
            if (s.indexOf(res.toString()) != 0)
                return false;
        }
        return false;
    }
}
```