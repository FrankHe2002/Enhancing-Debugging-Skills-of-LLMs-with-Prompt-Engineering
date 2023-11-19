```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        int[] res = new int[nums.length];
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(sorted, nums[i]);
            if (idx - 1 >= 0 && sorted[idx - 1] == nums[i]) {
                while (idx >= 0 && sorted[idx] == nums[i]) {
                    idx--;
                }
                idx++;
            }
            res[i] = idx;
        }
        return res;
    }

    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int m = (s + e) / 2;

        while (s <= e) {
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
            m = (s + e) / 2;
        }
        return -1;
    }
}
```