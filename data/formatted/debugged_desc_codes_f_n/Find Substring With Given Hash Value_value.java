```java
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] powers = new long[k];
        for (int i = 0; i < k; i++)
            powers[i] = binaryExponentiation(power, i, modulo);

        long currentHashValue = 0;
        for (int i = 0; i < k; i++) {
            currentHashValue = (currentHashValue + ((s.charAt(i) - 'a' + 1) % modulo * powers[k - i - 1] % modulo)) % modulo;
        }
        if (currentHashValue == hashValue) {
            return s.substring(0, k);
        }

        long subtraction = powers[k - 1];
        for (int i = 1; i <= s.length() - k; i++) {
            currentHashValue = (((currentHashValue - ((s.charAt(i - 1) - 'a' + 1) * subtraction) % modulo) + modulo) % modulo * power % modulo + (s.charAt(i + k - 1) - 'a' + 1) % modulo) % modulo;
            if (currentHashValue == hashValue) {
                return s.substring(i, i + k);
            }
        }
        return "";
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