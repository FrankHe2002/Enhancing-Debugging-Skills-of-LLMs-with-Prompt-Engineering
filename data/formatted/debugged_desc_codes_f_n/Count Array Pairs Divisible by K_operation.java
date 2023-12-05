```java
class Solution {
    public long countPairs(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums) {
            int gcd1 = gcd(val, k);
            if (gcd1 == 0) {
                hm.put(0, hm.getOrDefault(0, 0) + 1);
                continue;
            }
            int gcd2 = k / gcd1;
            ans += hm.getOrDefault(gcd2, 0L);
            hm.put(gcd1, hm.getOrDefault(gcd1, 0) + 1);
        }

        return ans;
    }

    //function to calculate gcd 
    public int gcd(int n1, int n2) {
        while (n2 > 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n1;
    }
}
```