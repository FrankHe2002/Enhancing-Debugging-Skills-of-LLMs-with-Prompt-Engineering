Fixed Buggy Code:
```java
class Solution {
    public int countMaxOrSubsets(int[] nums) {

        subsets(nums, 0, 0);
        return count;
    }

    int count = 0;
    int maxOR = Integer.MIN_VALUE;

    private void subsets(int[] arr, int vidx, int OR) {

        if (vidx == arr.length) {

            if (OR > maxOR) {
                count = 1;
                maxOR = OR;
            } else if (OR == maxOR) {
                count++;
            }

            return;
        }

        // include
        subsets(arr, vidx + 1, OR | arr[vidx]);

        // exclude
        subsets(arr, vidx + 1, OR);
    }
}
```