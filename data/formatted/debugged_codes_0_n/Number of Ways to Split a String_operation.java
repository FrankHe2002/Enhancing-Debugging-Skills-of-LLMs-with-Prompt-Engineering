```java
class Solution {
    public int numWays(String s) {
        int n = s.length();
        int one = 0;//to count number of ones
        int mod = 1_000_000_007;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1')
                one++;
        }

        //there will be 3 cases
        // 1.no ones present in the string
        // 2.number of ones present in the string isnt divisible by 3(since we need to cut 3 parts)
        // 3.number of ones divisible by 3

        if (one == 0)//case 1
        {
            return (int) ((((n - 1) * (n - 2)) / 2) * mod);
        }
        if (one % 3 != 0)//case 2,which means we cant split ones equally
            return 0;
        //case 3
        int ones = one / 3;//number of ones that should be present in each part
        one = 0;
        int part1 = 0;//number of ways in which part1 and part2 can be split
        int part2 = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1')
                one++;
            if (one == ones)
                part1++;
            if (one == 2 * ones)
                part2++;
        }

        return (int) ((part1 * part2) % mod);
    }
}
```