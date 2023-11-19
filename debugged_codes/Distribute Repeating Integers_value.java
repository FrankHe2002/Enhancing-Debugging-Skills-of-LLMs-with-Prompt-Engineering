import java.util.*;

class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        
        int[] dist = new int[freq.size()];
        int idx = 0;
        for (int f : freq.values()) {
            dist[idx++] = f;
        }
        
        Arrays.sort(quantity);
        return rec(dist, quantity, quantity.length-1);
    }
    
    private boolean rec(int[] dist, int[] quantity, int j) {
        
        if (j == -1) {
            return true;
        }
        
        Set<Integer> used = new HashSet<>();
        for (int i = 0 ; i < dist.length ; ++i) {
            
            if (dist[i] >= quantity[j] && used.add(dist[i])) {
                dist[i] -= quantity[j];
                if (rec(dist, quantity, j-1)) {
                    return true;
                }
                dist[i] += quantity[j];
            }
        }
        return false;
    }
}