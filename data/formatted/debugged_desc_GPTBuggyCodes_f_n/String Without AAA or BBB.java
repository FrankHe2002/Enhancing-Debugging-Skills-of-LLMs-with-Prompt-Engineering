```java
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a != 0 || b != 0) {
            if (a > b) {
                sb.append("a");
                a--;
                if (a > b) {
                    sb.append("a");
                    a--;
                }
                if (b > 0) {
                    sb.append("b");
                    b--;
                }
            } else if (b > a) {
                sb.append("b");
                b--;
                if (b > a) {
                    sb.append("b");
                    b--;
                }
                if (a > 0) {
                    sb.append("a");
                    a--;
                }
            } else {
                sb.append("a");
                a--;
                sb.append("b");
                b--;
            }
        }
        return sb.toString();
    }
}
```