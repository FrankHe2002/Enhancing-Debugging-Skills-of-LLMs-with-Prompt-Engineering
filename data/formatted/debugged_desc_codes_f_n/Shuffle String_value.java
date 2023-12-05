Fix:
```java
// Runtime: 1 ms (Top 100.00%) | Memory: 39.4 MB (Top 73.34%)
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ch);
    }
}
```