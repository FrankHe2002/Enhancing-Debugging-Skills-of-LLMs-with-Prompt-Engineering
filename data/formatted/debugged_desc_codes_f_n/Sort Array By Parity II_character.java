Fix:
```java
class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int even_index = 0;
        int odd_index = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] % 2 == 0) {
                ans[even_index] = nums[i];
                even_index += 2;
            } else {
                ans[odd_index] = nums[i];
                odd_index += 2;
            }

        }

        return ans;
    }
}
```