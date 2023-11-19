Bug type: Array Index Out of Bounds

Reasoning: The buggy code has a loop that iterates from 0 to `nums.length - 1`, inclusive. Inside the loop, there are two conditions that assign values to the `nums` array using the indices `left` and `right`. However, the initial values of `left` and `right` are `nums.length - 1` and `nums.length`, respectively. This means that on the last iteration of the loop, `nums[i] = a[right]` attempts to access `nums[nums.length]`, which is out of bounds. 

Fix: Change the initial value of `right` to `nums.length - 1`. 

```java
// Runtime: 7 ms (Top 77.52%) | Memory: 56 MB (Top 40.18%)
class Solution {
    public void wiggleSort(int[] nums) {
        int a[] = nums.clone();
        Arrays.sort(a);
        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = a[left];
                left--;
            } else {
                nums[i] = a[right];
                right--;
            }
        }
    }
}
```