```java
class Solution {
    public boolean checkPowersOfThree(int n) {
        int maxPower = (int) (Math.log(n) / Math.log(3));
        int[] threePower = new int[maxPower + 1];
        threePower[0] = 1;
        for (int i = 1; i <= maxPower; i++) {
            threePower[i] = threePower[i - 1] * 3;
        }
        for (int i = maxPower; i >= 0; i--) {
            if (n >= threePower[i]) { // changed ">" to ">="
                n -= threePower[i];
            }
        }
        return n == 0;
    }
}
```