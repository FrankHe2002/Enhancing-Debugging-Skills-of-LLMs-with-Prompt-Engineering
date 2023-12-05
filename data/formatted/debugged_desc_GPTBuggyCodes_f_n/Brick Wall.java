```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edge_frequency = new HashMap<>();
        int max_frequency = 0;

        for (List<Integer> row : wall) {
            int edge_position = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                int current_brick_length = row.get(i);
                edge_position += current_brick_length;
                int frequency = edge_frequency.getOrDefault(edge_position, 0) + 1;
                edge_frequency.put(edge_position, frequency);
                max_frequency = Math.max(max_frequency, frequency);
            }
        }
        return wall.size() - max_frequency;
    }
}
```