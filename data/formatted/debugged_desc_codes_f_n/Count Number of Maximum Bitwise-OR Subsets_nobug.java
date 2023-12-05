```java
class Solution {
    public int countMaxOrSubsets(int[] nums) {

        maxOR = 0;
        count = 0;
        subsets(nums, 0, 0);
        return count;
    }

    int count;
    int maxOR;

    private void subsets(int[] arr, int vidx, int OR) {

        if (vidx == arr.length) {

            if (OR == maxOR) {
                count++;
            } else if (OR > maxOR) {
                count = 1;
                maxOR = OR;
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