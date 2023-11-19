The code appears to have a bug in the following line:

```
engineers.add(new Engineer(speed[MB], efficiency[i]));
```

The variable `MB` is not defined in the code. It seems like there is a typographical error and `MB` should be replaced with `i`. This will correctly access the corresponding `speed` value for each engineer.

Below is the corrected code:

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
            engineers.add(new Engineer(speed[i], efficiency[i]));
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

The bug has been fixed by replacing `MB` with `i` in the line `engineers.add(new Engineer(speed[MB], efficiency[i]));`. Now, the code should correctly initialize the speed and efficiency values for each engineer.