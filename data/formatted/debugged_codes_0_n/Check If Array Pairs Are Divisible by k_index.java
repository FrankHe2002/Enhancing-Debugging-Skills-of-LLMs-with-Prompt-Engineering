```java
// Runtime: 4 ms (Top 82.69%) | Memory: 60.1 MB (Top 5.2%)

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for (int num : arr) {
            num %= k;
            if (num < 0) num += k;
            frequency[num]++;
        }
        if (frequency[0] % 2 != 0) return false;

        for (int i = 1; i <= k / 2; i++)
            if (frequency[i] != frequency[k - i]) return false;

        return true;
    }
}
```
