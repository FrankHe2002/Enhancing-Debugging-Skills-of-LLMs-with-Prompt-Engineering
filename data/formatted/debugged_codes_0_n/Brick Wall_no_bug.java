import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edge_frequency = new HashMap<>();
        int max_frequency = 0;

        for (int row = 0; row < wall.size(); row++) {
            int edge_position = 0;

            for (int brick_no = 0; brick_no < wall.get(row).size() - 1; brick_no++) {
                int current_brick_length = wall.get(row).get(brick_no);
                edge_position += current_brick_length;
                edge_frequency.put(edge_position, edge_frequency.getOrDefault(edge_position, 0) + 1);
                max_frequency = Math.max(edge_frequency.get(edge_position), max_frequency);
            }
        }
        return wall.size() - max_frequency;
    }
}