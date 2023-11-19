```java
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        int result = nums[0];
        while (result > 0) {
            if (nums[0] % result == 0 && n % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }
}
```