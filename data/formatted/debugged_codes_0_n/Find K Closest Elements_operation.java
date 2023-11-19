```java
// Runtime: 13 ms (Top 41.96-) | Memory: 62.2 MB (Top 71.32%)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int low = 0, high = arr.length - k; // Change: high = arr.length - k instead of arr.length - 1

        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high + k - 1] - x)) // Change: high + k - 1 instead of high
                low++;
            else
                high--;
        }

        for (int i = low; i < low + k; i++) // Change: i < low + k instead of i <= high
            result.add(arr[i]);

        return result;
    }
}
```