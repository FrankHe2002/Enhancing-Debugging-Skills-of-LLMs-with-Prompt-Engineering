```java
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] powers = new long[k];
        for (int i = 0; i < k; i++)
            powers[i] = binaryExponentiation(power, i, modulo);

        long currentHashValue = 0;
        int index = s.length() - 1;
        int powerIndex = k - 1;
        while (index >= s.length() - k) {
            currentHashValue += ((s.charAt(index--) - 'a' + 1) % modulo * powers[powerIndex--] % modulo) % modulo;
        }
        currentHashValue %= modulo;

        int startIndex = 0;
        if (currentHashValue == hashValue) {
            startIndex = s.length() - k;
        }

        for (int i = s.length() - k - 1; i >= 0; i--) {
            currentHashValue = ((currentHashValue % modulo) - (((s.charAt(i + k) - 'a' + 1) * powers[k - 1]) % modulo) + modulo) % modulo;
            currentHashValue = currentHashValue * power % modulo;
            currentHashValue = (currentHashValue % modulo + (s.charAt(i) - 'a' + 1) % modulo) % modulo;

            if (currentHashValue == hashValue) {
                startIndex = i;
            }
        }
        return s.substring(startIndex, startIndex + k);
    }

    private long binaryExponentiation(long a, long b, long mod) {
        a %= mod;
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1)
                result = result * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
}
```