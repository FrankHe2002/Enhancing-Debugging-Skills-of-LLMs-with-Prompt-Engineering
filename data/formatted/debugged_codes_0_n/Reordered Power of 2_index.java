```java
import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countN = new int[10];
        count(countN, n);
        int num = 1;
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(countN, count(new int[10], num))) {
                return true;
            }
            num = num << 1;
        }
        return false;
    }

    void count(int[] arr, int n) {
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
    }
}

```