Bug Type: Logical Error

The `waysToPartition` method contains a logical error in calculating the variable `pref` and using it in the later part of the solution. There is also an issue with the way the HashMaps are used, leading to incorrect evaluation of counts.

Fix:
```java
// Runtime: 532 ms (Top 32.98%) | Memory: 178.2 MB (Top 67.02%)
class Solution {
    //time - O(n), space - O(n)
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;

        long[] pref = new long[n]; // using long to avoid integer overflow
        pref[0] = nums[0];
        Map<Long, Integer> count = new HashMap<>(); //contribution of prefixes without changing
        count.put(pref[0], 1);

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
            count.put(pref[i], count.getOrDefault(pref[i], 0) + 1);
        }

        // Having separate handling of 'count' as countPrev was not required
        // Also fixing to use proper map for the addedSum maximum value
        long sum = pref[n - 1];
        int max = 0;
        if (sum % 2 == 0) //direct check with the count
            max = count.getOrDefault(sum / 2, 0) - 1; //max without changing

        for (int i = 0; i < n; i++) {
            long diff = k - (long) nums[i];
            long changedSum = sum + diff;
            if (changedSum % 2 == 0) {
                max = Math.max(max, count.getOrDefault(changedSum / 2, 0) - 1);
            }
        }
        return max;
    }
}
```