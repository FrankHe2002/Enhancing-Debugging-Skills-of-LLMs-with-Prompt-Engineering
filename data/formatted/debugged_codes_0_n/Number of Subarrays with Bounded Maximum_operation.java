```java
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int s = -1;
        int e = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left) {
                res += (e - s);
            } else if (nums[i] > right) {
                e = s = i;
            } else {
                e = i;
                res += (e - s);
            }
        }

        return res;
    }
}
```