The logic in the given code looks correct, but there seems to be an issue with the gcd function. 
The issue appears to be in the gcd function, where the return statement is returning n2 instead of n1, which should be changed to return n1.

Here's the fixed code with the gcd function corrected:

```java
class Solution {
    public long countPairs(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums) {
            int gcd1 = gcd(val, k);

            for (int gcd2 : hm.keySet()) {
                if ((long) gcd1 * gcd2 % k == 0) {
                    ans += hm.get(gcd2);
                }
            }

            hm.put(gcd1, hm.getOrDefault(gcd1, 0) + 1);
        }

        return ans;
    }

    //function to calculate gcd 

    public int gcd(int n1, int n2) {
        while (n1 - n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n1; // changed to return n1
    }
}
```