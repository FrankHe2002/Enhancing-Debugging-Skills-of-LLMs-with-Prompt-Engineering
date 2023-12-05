```java
// Runtime: 3 ms (Top 95.20%) | Memory: 53.3 MB (Top 91.54%)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int average = 0, count = 0, start = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            average = sum / k;
            if (average >= threshold) count++;
            sum = sum - arr[start] + arr[i];
            start++;
        }
        if (average >= threshold) count++;
        return count;
    }
}
```