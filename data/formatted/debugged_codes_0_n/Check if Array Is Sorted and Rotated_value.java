```java
class Solution {
    public boolean check(int[] nums) {
        int irregularities = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities <= 1;
    }
}
```