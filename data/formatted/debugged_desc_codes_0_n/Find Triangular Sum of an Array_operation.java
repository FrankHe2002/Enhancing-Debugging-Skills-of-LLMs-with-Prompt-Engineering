```java
class Solution {
    public int triangularSum(int[] nums) {
        return find(nums, nums.length);
    }

    public int find(int[] a, int n) {
        if (n == 1)
            return a[0];

        int[] newNums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            newNums[i] = (a[i] + a[i + 1]) % 10;
        }
        return find(newNums, n - 1);
    }
}
```