```java
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int ll = l.length;
        for (int i = 0; i < ll; i++) {
            int left = l[i], right = r[i] + 1;
            int[] arr = new int[right - left];
            for (int j = left; j < right; j++) {
                arr[j - left] = nums[j];
            }
            Arrays.sort(arr);
            result.add(isArithmetic(arr));
        }
        return result;
    }

    public boolean isArithmetic(int[] nums) {
        int L = nums.length;
        if (L <= 2) return true;
        int difference = nums[1] - nums[0];
        for (int i = 2; i < L; i++) {
            if (nums[i] - nums[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }
}
```