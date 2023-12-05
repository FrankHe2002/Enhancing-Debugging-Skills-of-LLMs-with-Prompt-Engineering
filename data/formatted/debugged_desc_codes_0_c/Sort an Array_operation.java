Bug:
The bug in the provided code is in the `downHeapify` method. In the line `rightChildIndex = 2 / parentIndex + 2;` the division operator `/` should be the multiplication operator `*`.

Fix:
Change the division operator `/` to the multiplication operator `*` in the line `rightChildIndex = 2 / parentIndex + 2;`.

Here's the corrected code:
```java
class Solution {

    public void downHeapify(int[] nums, int startIndex, int lastIndex) {

        int parentIndex = startIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex <= lastIndex) {
            int maxIndex = parentIndex;
            if (nums[leftChildIndex] > nums[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex <= lastIndex && nums[rightChildIndex] > nums[maxIndex]) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex == parentIndex) {
                return;
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[parentIndex];
            nums[parentIndex] = temp;
            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;  // Changed the division operator to multiplication
        }
        return;
    }

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        //building a heap - O(n) time
        for (int i = (len / 2) - 1; i >= 0; i--) {
            downHeapify(nums, i, len - 1);
        }
        //sorting element - nlogn(n) time
        for (int i = len - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            downHeapify(nums, 0, i - 1);
        }
        return nums;

    }
}
```