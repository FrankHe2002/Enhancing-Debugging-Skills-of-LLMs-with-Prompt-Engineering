```java
//odd-even=even
//even-odd=odd
class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        int even = 0;
        int odd = -1;

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum % 2 == 0) {
                ans += even + 1;
                even++;
            } else {
                ans += odd;
                odd++;
            }
        }

        return (int) (ans % (1000000007));
    }
}
```