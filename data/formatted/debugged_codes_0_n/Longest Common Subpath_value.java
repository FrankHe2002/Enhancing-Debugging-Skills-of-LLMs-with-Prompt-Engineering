```java
import java.util.*;

class Solution {
    long mod = 100_000_000_003L;
    long p = 100_003L;
    long p_i[];
    
    public int longestCommonSubpath(int n, int[][] paths) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        for (int path[] : paths) {
            max = Math.min(max, path.length);
        }
        
        p_i = new long[max + 1];
        p_i[0] = 1;
        
        for (int i = 1; i <= max; i++) {
            p_i[i] = mulmod(p_i[i - 1], p, mod);
        }
        
        int ans = 0;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (solve(mid, paths)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean solve(int len, int paths[][]) {
        Map<Long, Long> map = new HashMap<>();
        
        for (int path[] : paths) {
            long hash = 0L;
            Set<Long> set = new HashSet<>();
            
            for (int i = 0; i < len; i++) {
                hash = (hash + mulmod(p_i[len - i], (path[i] + 1), mod)) % mod;
            }
            
            set.add(hash);
            
            for (int i = len; i < path.length; i++) {
                long new_hash = (hash - mulmod(p_i[len], path[i - len] + 1, mod) + mod) % mod;
                new_hash = mulmod(new_hash, p, mod);
                new_hash = (new_hash + mulmod(p_i[1], path[i] + 1, mod)) % mod;
                hash = new_hash;
                set.add(new_hash);
            }
            
            for (long hsh : set) {
                map.put(hsh, map.getOrDefault(hsh, 0L) + 1L);
                if (map.get(hsh) == paths.length) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public long pow(long a, long b, long mod) {
       