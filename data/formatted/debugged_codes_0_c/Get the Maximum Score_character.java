The bug in this Java code is a missing closing parenthesis on the last line. 

To identify this bug, we can follow the process of reading the code line by line and checking for any syntax errors.

After reviewing the code line by line, we can see that it is missing a closing parenthesis on the last line, specifically in the return statement. 

To fix the bug, we need to add a closing parenthesis at the end of the return statement.

Here is the corrected code:

```java
class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long currSum = 0, sum1 = 0, sum2 = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                currSum += Math.max(sum1, sum2) + nums2[j];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else {
                sum2 += nums2[j++];
            }
        }

        while (i < nums1.length) {
            sum1 += nums1[i++];
        }
        while (j < nums2.length) {
            sum2 += nums2[j++];
        }
        return (int) ((currSum + Math.max(sum1, sum2)) % 1000000007);
    }
}
```