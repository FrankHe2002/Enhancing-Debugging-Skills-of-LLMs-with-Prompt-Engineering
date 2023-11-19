Bug type: Off-by-One Error

Reasoning process:
1. The code aims to find a substring in a given string `s` that matches a specific hash value (`hashValue`).
2. The code uses a sliding window approach to iterate through the string from the end to the beginning.
3. The initial hash value (`currentHashValue`) is computed correctly for the last `k` characters of the string.
4. However, when iterating through the rest of the string, starting from `s.length() - k - 1`, there is an off-by-one error:
   - Line 63: `currentHashValue = ((currentHashValue % modulo) - (((s.charAt(i + k) - 'a' + 1) * powers[k - 2]) % modulo) + modulo) % modulo;`
     - The index `i + k` should be `i + k - 1` to correctly compute the hash value for the current substring.
   - Line 66: `currentHashValue = currentHashValue * power;`
     - Multiplying `currentHashValue` by `power` is not necessary and should be removed.

Fix:
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
            currentHashValue = ((currentHashValue % modulo) - (((s.charAt(i + k - 1) - 'a' + 1) * powers[k - 2]) % modulo) + modulo) % modulo;
            currentHashValue = (currentHashValue % modulo + (s.charAt(i) -