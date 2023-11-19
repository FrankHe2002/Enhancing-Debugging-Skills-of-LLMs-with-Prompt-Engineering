Bug Type: ArrayOutOfBounds Exception

Reasoning: The bug is due to the incorrect comparison in the lambda expression used for sorting the `people` array. The lambda expression compares `a[0]` with `b[1]` instead of `a[1]` with `b[1]`. This causes an incorrect order to be applied when inserting the elements into the `result` list. As a result, it can go out of bounds when adding elements at certain positions.

Fix:
```java
// Runtime: 9 ms (Top 81.09%) | Memory: 53.8 MB (Top 84.02%)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>(); //return value

        Arrays.sort(people, (a, b) -> {
            int x = Integer.compare(b[0], a[0]);
            if (x == 0) return Integer.compare(a[1], b[1]); // fix comparison here
            else return x;
        });

        for (int[] p : people)
            result.add(p[1], p);

        return result.toArray(new int[people.length][2]);
    }
}
```