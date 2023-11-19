```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                prevSum += arr[j];
                if ((j - i + 1) % 2 == 1) {
                    sum += prevSum;
                }
            }
        }
        return sum;
    }
}
```