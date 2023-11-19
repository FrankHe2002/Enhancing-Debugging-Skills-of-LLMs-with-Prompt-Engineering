The bug in the provided code is in the calculation of the binary gap. The current implementation calculates the distance between consecutive '1's and takes the maximum of those distances. However, this is incorrect because the binary gap is defined as the maximum number of consecutive zeros between two '1's. 

To fix the bug, we need to modify the logic of calculating the binary gap. We should keep track of the positions of '1's and calculate the distance between them, while updating the maximum gap.

Here is the fixed code:

```java
class Solution {
    public int binaryGap(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        List<Integer> onesIndices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1')
                onesIndices.add(i);
        }
        int res = 0;
        for (int i = 0; i < onesIndices.size() - 1; i++) {
            res = Math.max(res, onesIndices.get(i + 1) - onesIndices.get(i));
        }
        return res;
    }
}
```

In this fixed code, we create a list `onesIndices` to store the indices of '1's in the binary string. We then iterate over `onesIndices` and calculate the gap between each consecutive pair of '1's by subtracting their indices. We update `res` with the maximum gap encountered. Finally, we return `res` as the result.