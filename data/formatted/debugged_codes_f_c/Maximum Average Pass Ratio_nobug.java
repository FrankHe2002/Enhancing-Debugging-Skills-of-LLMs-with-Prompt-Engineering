Bug Type: Division by zero

Explanation: The bug in the provided code occurs when calculating the average ratio in the `maxAverageRatio` method. In the `compare` method of the `PriorityQueue` comparator, there is a division operation `(a[0] / a[1])` and `(b[0] / b[1])`. However, if `a[1]` or `b[1]` is equal to 0, a `DivisionByZero` exception will be thrown.

To fix this bug, we need to add a check to ensure that `a[1]` and `b[1]` are not equal to 0 before performing the division operation. If `a[1]` or `b[1]` is equal to 0, we can simply return a negative or positive value accordingly to preserve the ordering of the elements in the `PriorityQueue`.

Fixed Code:
```java
// Runtime: 575 ms (Top 86.89%) | Memory: 100.8 MB (Top 90.16%)
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[1] == 0 || b[1] == 0) {
                    return a[1] == 0 ? -1 : 1;
                }
                double adiff = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);
                double bdiff = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
                if (adiff == bdiff) return 0;
                return adiff > bdiff ? - 1 : 1;
            }
        });

        for (int[] c : classes) pq.add(new double[] {c[0], c[1]});

        for (int i = 0; i < extraStudents; i++) {
            double[] curr = pq.poll();
            pq.add(new double[] {curr[0] + 1, curr[1] + 1});
        }

        double sum = 0;
        while (! pq.isEmpty()) {
            double[] curr = pq.poll();
            sum += curr[0] /