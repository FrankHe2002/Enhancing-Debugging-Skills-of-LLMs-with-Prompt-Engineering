```java
class Solution {
    public int countSegments(String s) {
        int length = 0;
        boolean flag = false;

        for (Character c : s.toCharArray()) {
            if (c != ' ' && !flag) {
                length++;
                flag = true;
            } else if (c == ' ') {
                flag = false;
            }
        }

        return length;
    }
}
```