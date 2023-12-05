Bug type: Syntax Error

The provided buggy Java code has a syntax error in the for loop statement.
In the line for (int i = 0 i < size; i++), there should be a semicolon between the conditions of the for loop.
Also, there are some minor syntax errors and inconsistencies in the original code that can be improved:
- The line "if (! set.contains(val)) set.add(val)" contains unnecessary parentheses.
- The last return statement should have "return -1;" instead of "return - 1;" to correctly return -1.

Fix:
```java
// Runtime: 907 ms (Top 10.13%) | Memory: 306.2 MB (Top 27.03%)
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int val = q.poll();
                if (val == goal) return res;
                if ((val < 0 || val > 1000) || set.contains(val)) continue;
                if (!set.contains(val)) set.add(val);

                for (int num : nums) {
                    q.offer(val + num);
                    q.offer(val - num);
                    q.offer(val ^ num);
                }
            }
            res++;
        }

        return -1;
    }
}
```