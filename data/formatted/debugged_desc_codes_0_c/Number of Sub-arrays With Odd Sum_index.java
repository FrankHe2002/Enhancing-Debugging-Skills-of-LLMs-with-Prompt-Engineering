The given code contains the following issues:

1. The for loop is not correctly iterating through the array. It is using `arr[3]` instead of `arr[i]` to calculate the `sum`.
2. The `even` and `odd` counts are being updated incorrectly.

To fix the issues, we need to:
1. Update the sum calculation to use `arr[i]`.
2. Update the logic for updating `even` and `odd` counts.

Here's the modified code with the fixes:

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        int even = 0;
        int odd = 0;

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even + 1;
                odd++;
            }
        }

        return (int) (ans % (1000000007));
    }
}
```

With the fixes applied, the code should now correctly count the number of subarrays with an odd sum.