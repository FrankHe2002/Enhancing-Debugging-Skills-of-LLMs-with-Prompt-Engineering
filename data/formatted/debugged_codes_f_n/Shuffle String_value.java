// Runtime: 2 ms (Top 100.00%) | Memory: 42.6 MB (Top 92.75%)
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ch); // change from "new String(ch)" to "String.valueOf(ch)"
    }
}