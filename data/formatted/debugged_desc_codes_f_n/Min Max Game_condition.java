```java
class Solution {
    public int minMaxGame(int[] nums) {
        var isMin = true;
        var n = 0;

        while (n < nums.length) {

            for (int i = 0; i < nums.length; i += n * 2) {
                nums[i / 2] = isMin ?
                        Math.min(nums[i], nums[i + 1]) :
                        Math.max(nums[i], nums[i + 1]);
                isMin = !isMin;
            }

            n *= 2;
        }

        return nums[0];

    }
}
```