```java
class Solution {
    public int subsetXORSum(int[] nums) {
        return getAns(nums, 0, 0);
    }

    int getAns(int[] arr, int i, int cur) {
        if (i == arr.length) {
            return cur;
        }
        return getAns(arr, i + 1, cur ^ arr[i]) + getAns(arr, i + 1, cur);
    }
}
```