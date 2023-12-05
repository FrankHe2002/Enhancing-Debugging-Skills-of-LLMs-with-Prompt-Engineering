The bug in the code is in the main loop that attempts to count the minimum number of swaps so that every couple is sitting side by side. The bug occurs due to incorrect logic to check and update the map of parents. The incorrect use of the `*=` operator does not update the count as intended.

Fix:
The fix involves updating the `count` variable, properly checking the condition to increment the count, and fixing the logic to check and update the map of parents. The corrected code is given below:

```java
class Solution {
    public int minSwapsCouples(int[] row) { // Union -Find pairs for 2
        Map<Integer, Integer> parents = new HashMap<>();
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int parent = Math.min(row[i], row[i + 1]);
            int child = Math.max(row[i], row[i + 1]);
            parents.put(parent, child);
        }
        for (int i = 0; i < row.length; i += 2) {
            if ((parents.containsKey(i) && parents.get(i) == (i + 1))
                    || (parents.containsKey(i - 1) && parents.get(i - 1) == i))
                continue;
            count++;
            int curChild = parents.get(i);
            int correctChildsChild = parents.get(i + 1);
            parents.remove(i + 1);
            parents.put(Math.min(curChild, correctChildsChild), Math.max(curChild, correctChildsChild));
            parents.put(i, i + 1);
        }
        return count;
    }
}
```