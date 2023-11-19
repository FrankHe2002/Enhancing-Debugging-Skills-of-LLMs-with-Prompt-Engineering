```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsClone = nums.clone();
        Arrays.sort(nums);

        int s = nums.length;
        int e = 0;

        for (int i = 0; i < nums.length; i++) {
            if (numsClone[i] != nums[i]) {
                s = Math.min(s, i);
                e = Math.max(e, i);
            }
        }

        if (s == nums.length || e == 0) {
            return 0;
        }

        return e - s + 1;
    }
}
```