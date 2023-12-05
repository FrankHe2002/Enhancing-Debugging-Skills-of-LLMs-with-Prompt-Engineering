```java
// Runtime: 2 ms (Top 100.00%) | Memory: 39.5 MB (Top 92.75%)
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
    }
}
```