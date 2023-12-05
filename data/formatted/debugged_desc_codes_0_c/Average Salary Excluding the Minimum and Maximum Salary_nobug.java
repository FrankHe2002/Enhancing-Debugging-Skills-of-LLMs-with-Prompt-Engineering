The issue in the given code is that it's not excluding the minimum and maximum salary from the sum when calculating the average.

Here's the step-by-step process to identify and fix the bug:

1. Initialize the `sum` variable to 0 to store the total sum of all salaries.
2. Initialize the `min` and `max` variables to `Integer.MAX_VALUE` and `Integer.MIN_VALUE` respectively to keep track of the minimum and maximum salaries.
3. Iterate through the `salary` array and calculate the sum of all salaries. Update `min` and `max` accordingly.
4. After the loop, subtract `min` and `max` from `sum` and then calculate the average.

Here's the fixed code in markdown format:

```java
class Solution {
    public double average(int[] salary) {
        int n = salary.length - 2;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }
        sum = sum - max - min;
        return (double) sum / n;
    }
}
```