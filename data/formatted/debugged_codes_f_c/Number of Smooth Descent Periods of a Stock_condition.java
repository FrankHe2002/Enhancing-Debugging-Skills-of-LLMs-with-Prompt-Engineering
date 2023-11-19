The bug in the provided code is in the condition `if (prices[j - 1] - prices[j] != 1)`. The intention of this condition is to check if the difference between the two adjacent prices is not equal to 1. However, the code mistakenly checks if the difference is not equal to 1 instead of checking equality.

To fix the bug, the condition should be changed to `if (prices[j - 1] - prices[j] == 1)`, correctly evaluating the intended condition.

Fixed Code:
```java
class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        int j = 1;
        long ans = 1;
        while (j < prices.length) {
            if (prices[j - 1] - prices[j] == 1) {
                //It means that j(current element) can be part of previous subarrays (j-i)
                //and can also start a subarray from me (+1). So add (j-i+1) in total Subarrays
                int count = j - i + 1;
                ans += count;
            } else {
                //It means that j cannot be part of previous subarrays but can start subarray from me. So, ans+=1
                i = j;
                ans += 1;
            }
            j++;
        }
        return ans;
    }
}
```