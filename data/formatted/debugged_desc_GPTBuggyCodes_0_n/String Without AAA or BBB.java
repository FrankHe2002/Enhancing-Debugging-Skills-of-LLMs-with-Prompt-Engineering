```java
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a > b) {
            int diff = a - b;
            if (diff > b) {
                sb.append("aab".repeat(b));
                sb.append("a".repeat(diff - b));
            } else {
                sb.append("aab".repeat(diff));
                sb.append("ab".repeat(b - diff));
            }
        } else if (a < b) {
            int diff = b - a;
            if (diff > a) {
                sb.append("bba".repeat(a));
                sb.append("b".repeat(diff - a));
            } else {
                sb.append("bba".repeat(diff));
                sb.append("ab".repeat(a - diff));
            }
        } else if (a == b) {
            sb.append("ab".repeat(a));
        }
        return sb.toString();
    }
}
```