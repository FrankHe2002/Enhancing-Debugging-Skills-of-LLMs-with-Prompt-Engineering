```java
import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        int[] res = new int[nums.length]; //result array
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; ++i) {
            int idx = binarySearch(sorted, nums[i]);
            res[i] = idx;
        }
        return res;
    }

    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int m;

        while (s <= e) {
            m = (s + e) / 2;
            if (arr[m] == target) {
                while (m >= 0 && arr[m] == target) {
                    m--;
                }
                return m + 1;
            } else if (arr[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
```