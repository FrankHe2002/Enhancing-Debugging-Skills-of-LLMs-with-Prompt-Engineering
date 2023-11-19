Bug Type: Array Index Out of Bounds Exception

Reasoning:
1. The code has a method named `convertToXorArray` that converts the given matrix into an XOR array.
2. In the `convertToXorArray` method, an array called `xor` is initialized with a length of `rows * cols`. This array is intended to hold the XOR values.
3. In the nested for loop that fills the `xor` array, the calculation of the index `xIdx` is incorrect. The correct calculation should be `var xIdx = r * cols + c`.
4. The incorrect index calculation leads to an out-of-bounds access when assigning values to the `xor` array.
5. As a result, when the code executes `xor[xIdx] = matrix[r][c];`, it will throw an ArrayIndexOutOfBoundsException.

To fix the bug, the incorrect index calculation in the `convertToXorArray` method should be corrected to `var xIdx = r * cols + c` before assigning values to the `xor` array.

Fixed code:

```java
// Runtime: 56 ms (Top 96.62%) | Memory: 250.3 MB (Top 62.84%)
class Solution {

    private static final Random RAND = new Random(0);

    public int kthLargestValue(int[][] matrix, int k) {
        var xor = convertToXorArray(matrix);
        var targetIdx = xor.length - k;
        sortPartially(xor, targetIdx, 0, xor.length);
        return xor[targetIdx];
    }

    void sortPartially(int[] nums, int targetIdx, int origLo, int origHi) {
        if (origHi - origLo < 2)
            return;

        var pivotIdx = RAND.nextInt(origHi - origLo) + origLo;
        var pivot = nums[pivotIdx];
        swap(nums, origLo, pivotIdx);

        var lo = origLo;
        var mid = lo + 1;
        var hi = origHi;
        while (mid < hi) {
            if (pivot < nums[mid])
                swap(nums, mid, -- hi);
            else if (pivot > nums[mid])
                swap(nums, mid++, lo++);
            else
                mid++;
        }

        if (targetIdx < lo)
            sortPartially(nums, targetIdx, origLo, lo);

        sortPartially(nums, targetIdx, mid, origHi);
