```java
// Runtime: 0 ms (Top 100.00%) | Memory: 36.9 MB (Top 39.95%)
class Solution {
    public int countSegments(String s) {
        int length = 0;
        boolean flag = false;

        for (Character c : s.toCharArray()) {
            if (c == ' ' && flag) {
                length++;
                flag = false;
            } else if (c != ' ') {
                flag = true;
            }
        }

        return flag ? length + 1 : length;
    }
}
```