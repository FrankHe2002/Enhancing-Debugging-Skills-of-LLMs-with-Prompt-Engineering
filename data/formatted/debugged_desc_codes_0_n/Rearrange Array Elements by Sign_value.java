```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int resIdx = 0;
        int posIdx = 1;
        int minusIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                while (posIdx < nums.length && nums[posIdx] < 0) posIdx += 2;
                res[resIdx++] = nums[posIdx];
                posIdx += 2;
            } else {
                while (minusIdx < nums.length && nums[minusIdx] > 0) minusIdx += 2;
                res[resIdx++] = nums[minusIdx];
                minusIdx += 2;
            }
        }

        return res;
    }
}
```