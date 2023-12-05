```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edge_frequency = new HashMap<>(); 
        int max_frequency = 0; 

        for (List<Integer> rowList : wall) {
            int edge_postion = 0; 

            for (int i = 0; i < rowList.size() - 1; i++) {
                int current_brick_length = rowList.get(i); 
                edge_postion += current_brick_length; 
                edge_frequency.put(edge_postion, edge_frequency.getOrDefault(edge_postion, 0) + 1); 
                max_frequency = Math.max(edge_frequency.get(edge_postion), max_frequency); 
            }
        }
        return wall.size() - max_frequency; 
    }
}
```