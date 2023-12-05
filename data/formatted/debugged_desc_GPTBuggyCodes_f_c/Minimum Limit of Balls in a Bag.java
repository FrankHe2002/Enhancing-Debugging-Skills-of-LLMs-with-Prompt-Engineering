```java
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min = 0;
        int max = 1000000000;
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int a : nums) {
                count += (a - 1) / mid;
            }
            if (count <= maxOperations) {
                max = mid;  // Change min to max
            } else {
                min = mid;
            }
        }
        return max;  // Change max to min
    }
}
```