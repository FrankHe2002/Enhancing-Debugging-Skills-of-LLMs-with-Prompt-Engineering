```java
class Solution {
    public int minimumBoxes(int n) {
        int result = 0;
        int base = 0;
        while (n > 0) {
            base++;
            n -= base * (base + 1) / 2;
            if (n >= 0) {
                result += base;
            }
        }
        return result;
    }
}
```