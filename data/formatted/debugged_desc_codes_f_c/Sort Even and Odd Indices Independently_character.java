Bug type: Syntax error, logical error

The bugs identified in the code are as follows:
1. There is a syntax error in the `if` statement inside the first for loop in the `sortEvenOdd` method. The statement `oddnums[i]]++;` is missing a dot (.) and should be `odd[nums[i]]++;`.
2. There is a logical error in the second for loop of the `sortEvenOdd` method. The variable `e` is incremented directly within the loop, which causes even numbers to be sorted in non-increasing order instead of non-decreasing order.

Fix:
```java
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] even = new int[101];
        int[] odd = new int[101];
        int length = nums.length;
        for (int i = 0; i < length; ++ i) {
            if (i % 2 == 0) {
                even[nums[i]]++;
            } else {
                odd[nums[i]]++; // Fix: changed oddnums[i] to odd[nums[i]]
            }
        }
        int e = 0;
        int o = 0; // Fix: changed o to 0
        for (int i = 0; i < length; ++ i) {
            if (i % 2 == 0) {
                // check even
                while (even[e] == 0) {
                    ++ e;
                }
                nums[i] = e;
                even[e]--;
            } else {
                while (odd[o] == 0) {
                    ++ o; // Fix: changed --o to ++o
                }
                nums[i] = o;
                odd[o]--;
            }
        }
        return nums;
    }
}
```