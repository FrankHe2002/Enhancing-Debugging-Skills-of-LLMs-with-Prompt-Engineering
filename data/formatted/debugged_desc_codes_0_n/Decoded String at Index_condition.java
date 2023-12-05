```java
class Solution {
    public String decodeAtIndex(String s, int k) {
        long sz = 0;
        for (char ch : s.toCharArray()) { // total length
            sz = Character.isDigit(ch) ? sz * (ch - '0') : ++ sz;
        }
        -- k; // make it 0 index based.
        for (int i = s.length() - 1; true; i--) {
            if (Character.isLetter(s.charAt(i)) && k == 0) { // found!
                return "" + s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                sz /= (s.charAt(i) - '0');
                k %= sz; // we are at the end of a multplied string, we can mod k with sz.
            } else {
                sz--; // reduce the total length for each letter
            }
        }
    }
}
```