```java
class Solution {
    public int minMaxGame(int[] nums) {
        var isMin = true;
        var n = 1;

        while (n < nums.length) {

            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < nums.length / 2; i++) {
                newNums[i] = isMin ? Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
                isMin = !isMin;
            }

            nums = newNums;
            n *= 2;
        }

        return nums[0];
    }
}
```