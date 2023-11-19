// Runtime: 17 ms (Top 18.46%) | Memory: 47.6 MB (Top 45.24%)
import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edge_frequency = new HashMap<>(); //HashMap to store the number of common edges among the rows
        int max_frequency = 0; //Variable to store the frequency of most occuring edge
        
        for(int row=0; row<wall.size(); row++) { //Iterating through each row
            int edge_position = 0; //Variable to store different edge position
            
            for(int brick_no=0; brick_no<wall.get(row).size()-1; brick_no++) { //Iterating through each brick inside a row
                int current_brick_length = wall.get(row).get(brick_no); //Length of the current brick
                edge_position += current_brick_length; //Next Edge Position = Previous Edge Position + Current Brick's Length
                edge_frequency.put(edge_position, edge_frequency.getOrDefault(edge_position, 0)+1); //Incrementing the Frequency of just calculated Edge Position
                max_frequency = Math.max(edge_frequency.get(edge_position), max_frequency); //Comparing the "Frequency of just calculated Edge Position" with "Max Frequency seen till now" & storing whichever is greater.
            }
        }
        return wall.size() - max_frequency; // returning (Number of Bricks Crossed by Line) i.e. (Number of Rows in Wall - Frequency of Most Occuring Edge)
    }
}