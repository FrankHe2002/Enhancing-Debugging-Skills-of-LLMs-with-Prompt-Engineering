The first step to identify the bug type is to understand the requirement and then review the code to see if it meets the requirement.

After reviewing the code, there's an issue with the calculation of the `each` variable, because it's positioned outside the loop and doesn't have a conditional check to validate if the array can be divided into three non-empty parts with the same binary value.

The `each` variable should represent the expected number of ones within each part of the divided array.

To fix this issue, the conditional check should be added, within which the `each` variable is calculated. The conditional check is also used for validating if `ones.size()` can be divided by 3, meaning the array can be divided into three non-empty parts.

Here's the corrected code:

```java
class Solution {
    public int[] threeEqualParts(int[] arr) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ones.add(i);
            }
        }

        if (ones.size() == 0) { // edge case
            return new int[]{0, 2};
        }

        int[] ans = new int[2];
        if (ones.size() % 3 == 0) {
            int each = ones.size() / 3;
            for (int i = 0; i < 2; i++) { // for the first 2 partitions
                // compare gaps
                for (int j = 0; j < each - 1; j++) {
                    if (ones.get(j + 1 + i * each) - ones.get(j + i * each) != ones.get(j + 2 * each + 1) - ones.get(j + 2 * each)) {
                        return new int[]{-1, -1};
                    }
                }
                ans[i] = ones.get((i + 1) * each - 1) + i + (arr.length - 1 - ones.get(ones.size() - 1)); // cut point
            }
            return ones.size() % 3 > 0 || ans[0] >= ones.get(each) || ans[1] > ones.get(2 * each) ?
                    new int[]{-1, -1} : ans;
        } else {
            return new int[]{-1, -1};
        }
    }
}
```