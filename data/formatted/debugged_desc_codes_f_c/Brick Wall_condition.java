The issue in the given code is that the for loop is iterating through each brick in each row, and the edge position is being incremented by the current brick's length instead of adding the length which should result in a common edge.

Fixing the issue will involve changing the line `edge_postion = edge_postion + current_brick_length;` to `edge_postion = edge_postion + wall.get(row).get(brick_no);`. After doing this, some minor improvements like changing variable names can be done for better readability.

The fixed code is as follows:

```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edgeFrequency = new HashMap<>();
        int maxFrequency = 0;

        for (List<Integer> row : wall) {
            int edgePosition = 0;

            for (int brickNo = 0; brickNo < row.size() - 1; brickNo++) {
                edgePosition += row.get(brickNo);
                edgeFrequency.put(edgePosition, edgeFrequency.getOrDefault(edgePosition, 0) + 1);
                maxFrequency = Math.max(edgeFrequency.get(edgePosition), maxFrequency);
            }
        }
        return wall.size() - maxFrequency;
    }
}
```