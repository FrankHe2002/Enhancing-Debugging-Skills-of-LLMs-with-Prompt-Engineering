```java
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int val : nums) {
            if ((val > 9 && val < 100) || (val > 999 && val < 10000) || (val > 99999 && val < 1000000))
                count++;
        }
        return count;
    }
}
```