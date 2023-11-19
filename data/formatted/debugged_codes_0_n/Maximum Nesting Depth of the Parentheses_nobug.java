```java
class Solution {
    public int maxDepth(String s) {
        int count = 0;   //count current depth of "()"
        int max = 0;     //count max depth of "()"

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
```