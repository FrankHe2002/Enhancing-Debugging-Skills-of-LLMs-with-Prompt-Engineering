The bug in the code lies in the compare() method of the Comparator used for the PriorityQueue. 

The compare() method is used to determine the ordering of elements in the PriorityQueue. It compares two elements of type double[] based on the difference between the average ratio of the elements and the increased average ratio if 1 student is added to each element.

The bug is that the comparison is reversed. The code currently returns -1 if adiff > bdiff, and 1 if adiff < bdiff. This means that the PriorityQueue is ordering elements in reverse order, resulting in incorrect output.

To fix the bug, we need to reverse the order of the return statements in the compare() method. We should return 1 if adiff > bdiff, and -1 if adiff < bdiff.

Here is the fixed code:

```java
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                double adiff = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);
                double bdiff = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
                if (adiff == bdiff) return 0;
                return adiff > bdiff ? 1 : -1; // fixed comparison
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
            sum += curr[0] / curr[1];
        }

        return sum / classes.length;
    }
}
```

With this fix, the code should correctly calculate the maximum average ratio.