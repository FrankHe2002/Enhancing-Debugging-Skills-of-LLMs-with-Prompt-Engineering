```java
class Solution {
    static long pow(long base, long exp) {
        long ans = 1;
        for (; exp != 0; ) {
            if ((exp & 1) == 1) {
                ans *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return ans;
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        if (num <= 10) {
            return String.valueOf(num - 1);
        }
        long comp[] = new long[5];
        comp[0] = pow(10, n.length() - 1) - 1;
        comp[1] = pow(10, n.length()) + 1;
        int mid = (n.length() + 1) / 2;
        long half = Long.parseLong(n.substring(0, mid));
	for(int i = 0; i < 3; i++) {
            long mod = comp[i] % 10;
            long check = comp[i];
            comp[i] -= mod;
            if ( mod == 0 || mod == 1 ) {
                min--;
                continue;
            } 
            if ( mod == 9 || mod == 8 ) {
                comp[i] = check - mod - 1;
                continue;
            }
            if ( mod > 1 && mod < 5 )
                comp[i] -= mod - 1;
            if ( mod > 4 )
                comp[i] += 10 - mod - 1;
	}
        long min = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long dif = Math.abs(num - comp[i]);
            if (dif != 0 && min > dif) {
                min = dif;
                ans = comp[i];
            } else if (min == dif) ans = Math.min(ans, comp[i]);
        }
        return String.valueOf(ans);
    }
}
```