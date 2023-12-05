Bug type: Semantic error

Explanation:
1. The loop iterates over the given array of integers, but the operation `sum += arr[3];` inside the loop always adds the value at index 3, which is a constant value and does not change with the iteration, leading to incorrect calculation of the sum of elements in the array.
2. The calculation for even and odd counts and the conditional addition of odd and even counts to the answer is incorrect, leading to incorrect computation of the number of subarrays with an odd sum.

Fix:
1. Change `sum += arr[3];` to `sum += arr[i];` to correctly calculate the sum of elements in the array.
2. Change `sum mod 2 == 0` to `sum mod 2 == 1` and swap the assignments for `even` and `odd` to correctly calculate the number of subarrays with an odd sum.

Fixed code:
```java
//odd-even=odd
//even-odd=odd
class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        int even = 0;
        int odd = 0;

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum % 2 == 1) {
                ans += even + 1;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }

        return (int) (ans % (1000000007));
    }
}
```