Bug type: Logical Error

The bug is in the for loop where the Engineer objects are created and added to the engineers list. The bug is within the loop condition `for (int i = 0; i < n; i++)` where it references `speed[MB]` instead of `speed[i]`. This is causing a compile-time error as the variable `MB` is not defined, and it is likely a typo.

To fix the bug, I will replace `speed[MB]` with `speed[i]` inside the for loop.

Here's the corrected code:

```java
// Runtime: 90 ms (Top 75.46%) | Memory: 69.9 MB (Top 33.86%)
class Engineer {
    int speed, efficiency;

    Engineer(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));  // Fix: Replace speed[MB] with speed[i]
        }
        engineers.sort((a, b) -> b.efficiency - a.efficiency);
        PriorityQueue<Engineer> maxHeap = new PriorityQueue<>((a, b) -> a.speed - b.speed);
        long maxPerformance = 0l, totalSpeed = 0l;
        for (Engineer engineer : engineers) {
            if (maxHeap.size() == k) {
                totalSpeed -= maxHeap.poll().speed;
            }
            totalSpeed += engineer.speed;
            maxHeap.offer(engineer);
            maxPerformance = Math.max(maxPerformance, totalSpeed * (long) engineer.efficiency);
        }
        return (int) (maxPerformance % 1_000_000_007);
    }
}
```