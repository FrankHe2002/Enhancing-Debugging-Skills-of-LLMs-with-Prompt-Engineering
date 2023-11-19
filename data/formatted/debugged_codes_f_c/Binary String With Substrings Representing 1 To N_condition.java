The bug in the provided code is in the loop condition `i >= n` within the `queryString` method. The loop should iterate as long as `i` is less than or equal to `n`, but the current condition causes the loop to exit immediately if `n > 1`. 

To fix this bug, the condition should be changed to `i <= n`. This ensures that the loop iterates from 1 to `n` inclusively.

Additionally, there is a typo in the method name. The method name is `toBinary`, but it is mistakenly spelled as `toBinar` in the `contains` method call. This should be fixed by correcting the method name to `toBinary`.

Fixed Code:
```java
class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(toBinary(i)))
                return false;
        }
        return true;
    }

    public String toBinary(int n) {
        String binary = "";
        while (n > 0) {
            int r = n % 2;
            binary = Integer.toString(r) + binary;
            n = n / 2;
        }
        return binary;
    }
}
```