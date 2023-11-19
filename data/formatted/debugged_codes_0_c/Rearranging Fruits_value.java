Bug type: Logical error

Reasoning:
1. The code initializes two hash maps `ac` and `cm` to track the count of each element in `basket1` and `basket2` respectively.
2. The code then iterates over the elements in `basket1` and updates the count in both `ac` and `cm` using the `merge` method. This is done correctly.
3. However, when updating the count in `cm` for the elements in `basket2`, the code mistakenly uses `cm.merge(basket1[i], 1, Integer::sum)` instead of `cm.merge(basket2[i], 1, Integer::sum)`. This means that the count of elements in `basket1` is being added to `cm` instead of the count of elements in `basket2`.
4. This mistake leads to incorrect counting and will affect the subsequent logic of calculating missing counts and swapping elements.

Fix:
Replace `cm.merge(basket1[i], 1, Integer::sum)` with `cm.merge(basket2[i], 1, Integer::sum)` in the second loop.

Fixed code:
```java
// Runtime: 84 ms (Top 22.7%) | Memory: 65.80 MB (Top 7.0%)

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        var ac = new HashMap<Integer, Integer>();
        var cm = new HashMap<Integer, Integer>();
        for (int i = 0; i < basket1.length; i++) {
            ac.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket1[i], 1, Integer::sum);
            cm.merge(basket2[i], 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;
        var m = new TreeMap<Integer, Integer>();
        for (var e : cm.entrySet()) {
            if (e.getValue() % 2 == 1) {
                return - 1;
            }
            min = Math.min(min, e.getKey());
            var missingCount = ac.getOrDefault(e.getKey(), 0) - e.getValue() / 2;
            if (missingCount == 0) {
                continue;
            }
            // we don't care if missingCount is positive or negative, we care that it's != 0
            // i.e. arrays have different count of this number
            m.merge(e.getKey(), Math.abs(missing