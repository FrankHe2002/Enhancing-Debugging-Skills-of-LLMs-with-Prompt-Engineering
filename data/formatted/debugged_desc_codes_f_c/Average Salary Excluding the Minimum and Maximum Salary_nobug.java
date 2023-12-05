The bug in the Java code is in the `average` method. The issue is that the loop `for (int i = 0; i < n + 2; i++)` iterates through the entire array without excluding the minimum and maximum salaries. This leads to incorrect calculations of the average.

The fix is to adjust the loop to start at index 1 and end at index n, meaning it excludes the minimum and maximum salary values.

Fix:
```java
class Solution {
    public double average(int[] salary) {
        int n = salary.length - 2;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }
        return (double) (sum - max - min) / n;
    }
}
```