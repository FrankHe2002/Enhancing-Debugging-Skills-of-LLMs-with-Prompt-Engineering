Bug Type: Incorrect calculation of the average

Reasoning:
1. The code calculates the average salary by summing up all the salaries and then subtracting the maximum and minimum values before dividing by the number of salaries.
2. However, there is a bug in the calculation of the number of salaries (`n` variable).
3. The code sets `n` to be `salary.length - 2`, which assumes that there are only two employees whose salaries are not included in the array.
4. This assumption is incorrect and leads to the incorrect calculation of the average.

Fix:
- To fix the bug, we need to calculate the number of salaries accurately.
- We can do this by simply setting `n` to `salary.length`, as we want to include all the salaries in the array.

Fixed Code:
```java
class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += salary[i];
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
        }
        return (double) (sum - max - min) / (n - 2);
    }
}
```