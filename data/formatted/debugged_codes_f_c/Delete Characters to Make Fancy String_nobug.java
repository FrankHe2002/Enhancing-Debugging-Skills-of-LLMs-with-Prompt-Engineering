Buggy Code Explanation:
The bug in this code is that it doesn't correctly remove consecutive characters appearing more than two times in a row. The condition `if (freq < 3)` should actually be `if (freq <= 2)` in order to include consecutive characters appearing twice in a row.

Bug Type:
Logic Error

Fix and Final Code:
```java
class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int freq = 1;
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev)
                freq++;
            else {
                prev = s.charAt(i);
                freq = 1;
            }
            if (freq <= 2) // Change made here
                res.append(s.charAt(i));
        }
        return res.toString();
    }
}
```