```java
class Solution {

    public int longestDecomposition(String text) {
        int n = text.length();
        for (int i = 0; i <= n / 2; i++) {
            if (text.substring(0, i).equals(text.substring(n - i, n))) {
                if (i == 0) {
                    return 1;
                }
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return 1;
    }
}
```