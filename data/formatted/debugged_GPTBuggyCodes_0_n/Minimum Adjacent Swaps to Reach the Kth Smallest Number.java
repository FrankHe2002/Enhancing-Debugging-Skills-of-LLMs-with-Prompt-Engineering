```java
class Solution {
    public int getMinSwaps(String num, int k) {
        int[] nums = new int[num.length()];
        int[] org = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            int e = Character.getNumericValue(num.charAt(i));
            nums[i] = e;
            org[i] = e;
        }

        while (k != 0) {
            nextPermutation(nums);
            k--;
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != org[i]) {
                int j = 0;
                for (j = i + 1; j < nums.length; j++)
                    if (org[j] == nums[i])
                        break;

                while (j > 0 && j != i) {
                    int temp = org[j];
                    org[j] = org[j - 1];
                    org[j - 1] = temp;
                    ans++;
                    j--;
                }

            }

        }

        return ans;

    }

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1)
            return;

        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1])
            j--;

        if (j >= 0) {
            int k = nums.length - 1;
            while (nums[j] >= nums[k])
                k--;

            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;

        }

        reverse(nums, j + 1, nums.length - 1);

    }

    public void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
```