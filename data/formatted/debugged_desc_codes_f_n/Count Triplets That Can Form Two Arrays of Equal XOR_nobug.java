```java
// Runtime: 0 ms (Top 100.00%) | Memory: 38.8 MB (Top 77.00%)
class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                val = val ^ arr[k];
                if (val == 0) count += k - i;
            }
        }
        return count;
    }
}
```