The bug in the code provided is that it does not handle the case where there are no negative numbers. If the minimum value found in the array is Integer.MAX_VALUE, it will lead to the wrong output.

Fix:
```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE, closest_num = 0;
        for (int n : nums) {
            if (min > Math.abs(n)) {
                min = Math.abs(n);
                closest_num = n;
            } else if (min == Math.abs(n) && closest_num < n) {
                closest_num = n;
            }
        }
        if (min == Integer.MAX_VALUE) {
            for (int n : nums) {
                if (min > n) {
                    min = n;
                    closest_num = n;
                } else if (min == n && closest_num < n) {
                    closest_num = n;
                }
            }
        }
        return closest_num;
    }
}
```